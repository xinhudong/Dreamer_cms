package cc.iteachyou.cms.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import cc.iteachyou.cms.common.ExceptionEnum;
import cc.iteachyou.cms.entity.Theme;
import cc.iteachyou.cms.exception.AdminGeneralException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZipUtils {
	/**
	 * 解压文件到指定目录
	 * @throws AdminGeneralException 
	 */
	@SuppressWarnings("rawtypes")
	public static Theme unZipFiles(File zipFile, String descDir) throws IOException, AdminGeneralException {
		File pathFile = new File(descDir);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		Theme theme = new Theme();
		// 解决zip文件中有中文目录或者中文文件
		ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
		for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String entryName = entry.getName();

			Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");
			Matcher matcher = pattern.matcher(entryName);
		    if(entryName.contains("../") || entryName.contains("..\\") || matcher.find()) {
				log.error("压缩包中文件名疑似不安全，详情：{}", entryName);
				throw new AdminGeneralException(
						ExceptionEnum.XSS_SQL_EXCEPTION.getCode(),
						ExceptionEnum.XSS_SQL_EXCEPTION.getMessage(),
						"压缩包中文件名疑似不安全，详情：" + entryName);
			}
			InputStream in = zip.getInputStream(entry);
			String outPath = (descDir + entryName).replaceAll("\\*", "/");
			// 判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if(file.getParent().equals(pathFile.getAbsolutePath()) && file.isDirectory()) {
				theme.setThemePath(file.getAbsolutePath());
			}
			
			if (!file.exists()) {
				file.mkdirs();
			}
			// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
			if (new File(outPath).isDirectory()) {
				continue;
			}
			
			OutputStream out = new FileOutputStream(outPath);
			byte[] buf1 = new byte[1024];
			int len;
			while ((len = in.read(buf1)) > 0) {
				out.write(buf1, 0, len);
			}
			in.close();
			out.close();
		}
		zip.close();
		log.info("******************解压完毕******************");
		return theme;
	}
}
