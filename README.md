<p align="center">
	<a href="https://www.iteachyou.cc/" target="_blank"><img src="https://oss.iteachyou.cc/logo.png" width="400" ></a>
</p>

<div style="display: flex; justify-content: center;">

[![OSCS Status](https://www.oscs1024.com/platform/badge/isoftforce/dreamer_cms.git.svg?size=small)](https://www.murphysec.com/dr/uURRBRDjHq7ttx9MvG)
[![Apache-2.0](https://img.shields.io/badge/license-Apache%202-blue)](https://github.com/murphysecurity/murphysec/blob/master/LICENSE)
[![Star 1000+](https://img.shields.io/badge/stars-%E2%98%85%E2%98%85%E2%98%85%E2%98%85%E2%98%86-brightgreen)](https://gitee.com/isoftforce/dreamer_cms/stargazers)

</div>

# 梦想家内容管理系统（Dreamer CMS）
> 目前服务器快要到期，个人经济压力过大，该项目寻找接手公司，有意向者请与作者联系。

> 本人为个人开发者，精力和经济都有限，如有公司或个人想要商业使用，捐赠200即可，捐赠后，会将公司或个人名称列在下方捐赠列表，在列表中的企业或个人，即表示授权。

> 如未授权，根据软件使用协议，请务必保留官方版权。前后台页底必须保留 "Powered by I Teach You , 我教你！" 文字和链接！如未按要求保留官方版权且未授权用户，将依法追究法律责任。

> 鼓励大学毕业生在此开源项目基础上进行毕业设计项目开发，但请遵守开源协议并添加自己的开发和创新内容，且论文中应明确标注源码的来源；拿来就用主义者视为侵权。

当前版本：4.1.3

1. 梦想家CMS官网：http://cms.iteachyou.cc
2. 梦想家CMS管理后台：http://cms.iteachyou.cc/admin
- 演示账号：demo1
- 演示密码：123456
- 管理员：wangjn
- 管理员密码：123456
3. I Teach You,我教你! 官网：https://www.iteachyou.cc
4. 模版标签开发教程请参考：http://doc.iteachyou.cc 或 https://iteachyou-wjn.github.io/dreamer_cms/

QQ交流群：
- ①597652651（未满）
- ②623605199（已满）
- ③573574854（未满）

微信交流群：
- 可添加群主微信好友，群主拉群；微信二维码见下方。

DreamerCMS（梦想家CMS内容管理系统）史上最精简的CMS系统，完全开源、完全免费。公开解决了快速搭建展示型网站（如：企业官网、技术博客、信息门户等）的框架体系，是电子政务、电信综合门户、企业信息门户、知识管理平台、电子商务平台的基础性软件系统。可以帮助政府、企业或组织灵活、准确、高效、智能地管理信息内容，实现信息的采集、加工、审核、发布、存储、检索、统计、分析、 反馈等整个信息生命周期的管理。采用时下最流行的Springboot+thymeleaf框架搭建，具有灵活小巧，配置简单，标签化模版，快速开发等特点。主要解决公司搭建网站成本高、投入大、周期长等问题，也可作为初创公司很好的基础技术框架。使用过程中不需要专业的后端技术开发技能，只要使用系统提供的模版标签，即可轻轻松松建设网站。

DreamerCMS从2.0.0版本开始采用了解析式引擎与编译式引擎并存的模式，由于在解析模版时，解析式引擎拥有巨大的优势，但对于动态浏览的互动性质的页面，编译式引擎更实用高效，DreamerCMS采用双引擎并存的模式，在保持标签风格一致性的同时，也保证将来开发更多互动模块时有更好的性能和更好的扩展。
# 特点
* 免费开源：基于APACHE 2.0开源协议，源代码完全开源；
* 标签建站：不需要专业的后台开发技能，只要使用系统提供的标签，就能轻松建设网站；
* 开发方便：支持在线上传模版包开发方便快捷；
* 零代码量：真正实现“0”代码建站，后台代码一点都不需要动；
* 每月更新：每月进行系统升级，分享更多好用的模版与插件。

# 面向对象
* 政府：可以使用Dreamer CMS来快速构建政府门户；
* 电信：可以使用Dreamer CMS来快速构建电信综合门户；
* 企业：可以使用Dreamer CMS构建信息门户，知识管理平台，也可作为基础技术框架，是企业在创立初期很好的技术选型；
* 个人开发者：可以使用Dreamer CMS承接外包项目；

# 技术框架
* 核心框架：Spring Boot 2
* 安全框架：Apache Shiro 1.9.1
* 工具包：Hutool 5.8.5
* 持久层框架：MyBatis 2.2.2
* 日志管理：Logback
* 模版框架：Thymeleaf
* JS框架：jQuery，Bootstrap
* CSS框架：Bootstrap
* 富文本：Ueditor、editor.md

# 系统结构
![系统结构](https://oss.iteachyou.cc/20200107103015.jpg "系统结构")

# 开发环境
建议开发者使用以下环境，这样避免版本带来的问题
* JDK：Jdk8
* IDE：Spring Tool Suite 4（STS）或 IntelliJ IDEA
* DB：Mysql 5.7，Windows配置安装Mysql5.7，请参考：https://www.iteachyou.cc/article/a1db138b4a89402ab50f3499edeb30c2
* Redis：3.2+，Windows配置安装Redis教程，请参考：https://www.iteachyou.cc/article/4b0a638f65fa4fb1b9644cf461dba602
* LomBok 项目需要使用Lombok支持，Lombok安装教程，请参考：https://www.iteachyou.cc/article/55ec2939c29147eca5bebabf19621655

# 快速入门
CMS包括两个部分（代码部分、资源部分）代码不多说。资源就是图片、模版等，该目录在application.yml中web.resource-path配置项目中配置。视频教程：
```
Dreamer CMS后台使用教程：
https://www.iteachyou.cc/list-6s3bg7tf/dreamercms/1/10
Dreamer CMS模版开发教程：
https://www.iteachyou.cc/list-l54xs53b/tempdev/1/10

百度网盘下载链接：
https://pan.baidu.com/s/16nLVa44OkloL8sTpW6e2QQ 提取码：2c8i 

在线观看视频地址：
https://space.bilibili.com/482273402
```
1. 克隆项目到本地工作空间
2. 导入Eclipse或Sts等开发工具（推荐使用Spring Tools Suite 4），项目需要使用Lombok支持，Lombok安装教程，请参考https://www.iteachyou.cc/article/55ec2939c29147eca5bebabf19621655
3. 项目需要Redis，请自行修改application.yml中Redis配置
4. 修改项目资源目录，application.yml文件web.resource-path配置项（如D:/dreamer-cms/）
5. 导入数据库src/main/resources/db/db.sql，要求Mysql5.7版本，并修改application-(dev|prd).yml中数据配置
6. 将项目src/main/resources/db/dreamer-cms.zip文件解压，保证解压后的目录路径的名称和资源目录一致
7. 运行项目DreamerCMSApplication.java
8. 网站首页：http://localhost:8888 项目管理后台：http://localhost:8888/admin
9. 管理后台用户名：wangjn；密码：123456
10. 模版标签开发教程请参考：http://doc.iteachyou.cc 

# 捐赠详情 

感谢各位大佬的支持，同时也感谢各位开发者为社区作出的贡献。同时也希望更多的用户来捐赠本项目。您的支持，是我一直坚持下去的动力，另外为大家提供使用文档（ https://doc.iteachyou.cc ）、教程（ https://www.iteachyou.cc ）的网站及服务器也需要运营维护，个人精力、经费都有限，希望大家多多理解！！！捐赠详情请移步：http://doc.iteachyou.cc/chapter10/DonationList.html

<table>
	<tr>
		<td width="33.33%"><img src="https://oss.iteachyou.cc/20201201174329.png" /></td>
		<td width="33.33%"><img src="https://oss.iteachyou.cc/20201201174339.jpg" /></td>
		<td width="33.33%"><img src="https://oss.iteachyou.cc/20230327163517.jpg" /></td>
	</tr>
</table>


# 系统美图

<img src="https://oss.iteachyou.cc/20190821102434.png"/>
<img src="https://oss.iteachyou.cc/20190821102526.png"/>
<img src="https://oss.iteachyou.cc/20190821102608.png"/>
<img src="https://oss.iteachyou.cc/20190821102712.png"/>
<img src="https://oss.iteachyou.cc/20190821102742.png"/>
<img src="https://oss.iteachyou.cc/20190821102847.png"/>
<img src="https://oss.iteachyou.cc/20190821102932.png"/>
<img src="https://oss.iteachyou.cc/20190821103012.png"/>
<img src="https://oss.iteachyou.cc/20190820092155.png"/>
<img src="https://oss.iteachyou.cc/20190820092156.png"/>
<img src="https://oss.iteachyou.cc/20190820092157.png"/>
<img src="https://oss.iteachyou.cc/20190820092158.png"/>