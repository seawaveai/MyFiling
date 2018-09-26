### 使用studio的必要性
> * 官方推荐的工具就是studio;
> * Google已经宣布将在今年底终止Eclipse Android工具的开发与支持。这包括ADT插件、Ant构建系统、DDMS、Traceview与其他性能和监控工具;
> * 众多开源软件都是使用as构建;
> * as基于强大的是`最智能的JAVA IDE -IntelliJ IDEA`;
> * `2013年5月16日`，在I/O大会上，谷歌推出新的Android开发环境——Android Studio,`2015年5月29日`，在谷歌I/O开发者大会上，谷歌发布AndroidStudio 1.3版,现在最新版本已经是2.0正式版了(个人经验,1.2.2之后就比较好用了),`2016年4月8日`谷歌发布2.0正式版
> * 1.3之后,开始支持ndk,开始支持c++
> * 2.0 加入instant run,模拟器比之前更快2,3倍

### 随便举几个优点
 1. 集成了Gradle 打包工具
 2. 所见即所得的效果
 3. 可拖拽的UI操作 
 4. 代码自动补全
 5. 更多的操作接口
 6. Google Cloud的集成
 7. 全新的JUnit
 8. Maven仓库的集成
 
### as与eclipse
	ant-->eclipse-->压根不知道什么是ant-->xml写的-->显得非常冗余
	gradle-->as--->必须要了解gradle-->groovy写的-->精简
			
	gradle-->php  要php插件
	gradle-->.net 要.net插件 
	gradle-->java 
	gradle-->android -->谷歌就开发了插件Android Gradle Plugin,从而在as上可以使用gradle.
			
	1.(gradle是一个公司开发的软件,gradle Plugin是谷歌为了android能使用, 基于gradle的一个插件)
	2.(D:\ProgramSoftware\android-studio1.5\gradle\gradle-2.8, 是gradle的版本)
	3.(build.gradle里面的-->classpath 'com.android.tools.build:gradle:1.5.0', 这个是谷歌基于gradle开发的插件版本)
			
	特点:
		使用领域专用语言DSL来描述和控制构建
 
### as下载
> http://www.androiddevtools.cn/

### as教程
> http://www.jetbrains.com/idea/help/android-reference.html

### 安装步骤
1. 解压Android Sdk
2. 配置文件放到`C:\Users\{用户}`文件夹下 (C:\Users\Xikang\.AndroidStudio2.2\config)
3. 解压1.5或者2.0正式版,双击bin/studio64.exe启动
	0. 创建一个新的project
	1. 修改下Android Sdk路径,可以直接全局修改
	2. 修改下JDK路径,只有创建了一个project才可以修改
	3. svn的小乌龟路径统一去掉对勾
	4. 如果用到了genymotion,修改修改genymotion的指向路径
4. 模拟的使用
	1. 在as里面,如果配置了ANDROID_SDK_HOME=D:\android\android-sdk环境变量,可以直接看到之前的eclipse里面创建好的模拟器,但是基本启动不成功;不是代表不能用,而是说不能用as的avd manager启动,应该用之前的eclipse avd manager启动;
	2. 如果你的as的android sdk包含了自己下载的system image,就可以自行在as的avd manager里面创建新的模拟器

## as的2个目录

###as安装目录
> C:\xxxx\yyyy\Android Studio(安装目录)
	
		bin 运行文件
			|-idea.properties 配置缓存目录,配置第一次启动是否加载sdk(1.4之后不用修改了)等
			|-studio64.exe 如果是64位电脑,就点击运行
			|-studio64.exe.vmoptions 是64位电脑对应的配置文件(分配as运行时的堆内存)
			|-studio.exe 如果是32位电脑,就点击运行
			|-studio32.exe.vmoptions 是32位电脑对应的配置文件(分配as运行时的堆内
		build.txt
		gradle
			|-gradle-2.4 gradle 所在的文件夹
			|-m2repository 仓库中定义了一些运行需要的jar
		lib 
		license
		NOTICE.txt
		plugins android studio 的插件目录
		uninstall.exe 双击卸载

###as配置目录
> C:\Users\Administrator\.AndroidStudio1.5 (如果是1.4对应就是.AndroidStudio1.4)

1. config:用户配置文件,用户的个人设置-->**注意备份,as的配置插件都在这**
2. restart:不用关心
3. system:运行的生成的缓存环境,**会越来越大**
		
		* 磁盘空间小.可以考虑配置在磁盘空间大的盘里面,用十多天,现在差不多1.5g
		* system可以删除.但是第一次使用的时候会初始化一些数据.
		* 可以通过修改idea.properties文件修改默认路径`idea.system.path=${idea.home.path}

### as的一些配置	
* 针对Gradle的一些配置

		* GRADLE_HOME -->指向gradle的目录-->必须配置(C:\ZSoftware\as2.2.2\gradle\gradle-2.14.1)
		* path-->%GRADLE_HOME%\bin-->必须配置
		* GRADLE_USER_HOME-->指向.gradle文件夹所在的目录-->可选,gradle构建时的缓存。

* 可以修改`idea.properties`

		# 禁止第一次运行Android Studio时，自动检查和升级Android SDK(1.5不需要配置也可以启动,但是还是会去检测,建议加上如下配置)
		   	disable.android.first.run=true
		# 不改的话，Windows中默认在 C:\Users\<username>\.AndroidStudio1.5\ 里面
		# ${idea.home.path}表示Android Studio程序的主目录，注意目录分隔符要用正斜杠“/”
		   	idea.config.path=${idea.home.path}/.AndroidStudio1.5/config
		  	idea.system.path=${idea.home.path}/.AndroidStudio1.5/system

### as里面Projects和Module的概念
	* 分为`as设置(settings)`和`project 设置(project structure)`
	* Project:类似eclipse的工作空间(workspace),里面放置的一个个Module,但是应该放置和同一个Project相关的Module;
	* Module:对应的就是一个独立的`可执行程序`或者`公共的库`;
	* AS里面,Project和Project是相互独立的;

### 一个project里面有多个.gradle脚本,但是只有两种类型
	1.project级别的脚本-->一个project只存在一个
	2.module级别的脚本-->一个module就会有一个

### 项目结构
> 参考文档:`file:///F:/android-sdk-studio-new/docs/tools/projects/index.html#ProjectFiles`

	C:.
	├─.gradle
	├─.idea
	│  build.gradle     项目Gradle构建脚本
	│  gradle.properties  项目Gradle属性文件
	│  gradlew       在没有安装gradle的pc上使用,没用
	│  gradlew.bat   在没有安装gradle的pc上使用,没用
	│  local.properties  指定sdk所在目录
	│  settings.gradle  项目Gradle设置文件
	│  
	├─app
	│  │  .gitignore   git忽略文件列表
	│  │  app.iml   临时文件,不需要关心
	│  │  build.gradle  Module Gradle构建脚本
	│  │  proguard-rules.pro   proguard混淆规则
	│  │  
	│  ├─build  构建目录，相当于Eclipse中默认Java工程的bin目录。编译生成的apk在此目录
	│  ├─libs   依赖包
	│  └─src
	│      ├─androidTest  测试相关代码文件夹
	│      │  └─java
	│      │      └─com
	│      │          └─itheima
	│      │              └─myapplication
	│      │                      ApplicationTest.java
	│      │                      
	│      └─main
	│          │  AndroidManifest.xml   清单文件
	│          │  
	│          ├─java       项目源码
	│          │  └─com
	│          │      └─itheima
	│          │          └─myapplication
	│          │                  MainActivity.java
	│          │                  
	│          └─res        资源文件
	│              ├─drawable  .9图片只能放到drawable目录下
	│              ├─layout
	│              │      activity_main.xml
	│              │      
	│              ├─menu
	│              │      menu_main.xml
	│              │      
	│              ├─mipmap-hdpi            类似drawable-hdpi
	│              │      ic_launcher.png
	│              │      
	│              ├─mipmap-mdpi            类似drawable-mdpi
	│              │      ic_launcher.png
	│              │      
	│              ├─mipmap-xhdpi           类似drawable-xdpi
	│              │      ic_launcher.png
	│              │      
	│              ├─mipmap-xxhdpi           类似drawable-xxdpi
	│              │      ic_launcher.png
	│              │      
	│              ├─values
	│              │      dimens.xml
	│              │      strings.xml
	│              │      styles.xml
	│              │      
	│              └─values-w820dp
	│                      dimens.xml
	│                      
	├─build
	└─gradle
	    └─wrapper   gradle wrapper可以看作是对gradle的封装，它可以使得在没有安装gradle的电脑上也可以使用Gradle进行构建.没啥用
	            gradle-wrapper.jar
	            gradle-wrapper.properties
	            
### mipmap目录和drawable目录有什么区别

	使用上没有任何区别,你把它当drawable用就好了。
	但是用mipmap系统会在缩放上提供一定的性能优化。
	mipmap里面不能放置.9图片

### 需要自己建立的文件夹

	main/assets/ 
	main/aidl/
	main/jni/     -->放置c代码
	main/jniLibs/ -->放置so库
	main/res/raw/
	main/res/anim/

### 什么是Gradle？
	Gradle是一种依赖管理工具，基于Groovy语言，面向Java应用为主，它抛弃了基于XML的各种繁琐配置，
	取而代之的是一种基于Groovy的内部领域特定（DSL）语言。
	Win平台会默认下载到 C:\Documents and Settings<用户名>.gradle\wrapper\dists 目录

### gradle构建
> * Android Studio使用`Gradle`构建工具，Eclipse的ADT插件使用的是`Ant`构建工具
> * 程序生成过程:http://blog.sina.com.cn/s/blog_a46817ff0102uylb.html
> * 要把Ant或者Gradle学的很深入需要花一周时间,但是我们IDE已经帮我们封装好了,`只需要简单了解`
> * Gradle针对不同语言有不同插件,在Android平台叫`Android Gradle Plugin`

### Android Gradle Plugin参考资料
> * google官网参考(需翻墙):http://tools.android.com/tech-docs/new-build-system/user-guide
> * google官网本地:Gradle Plugin User Guide - Android Tools Project Site.mht
> * 博客翻译: Android Gradle Plugin指南（一）——简介
> * 整合pdf:gradle-plugin-user-guide.pdf
> * Gradle官网:http://gradle.org

### 概念
* 构建:生成app的过程,执行一些的命令(appt,aidl,javac,dex,apkbuilder,jarsinger,zipalign)
* 依赖管理:管理依赖的jar包
* 仓库:简单理解就是存的一些jar包云端
	* maven
	* ivy
	* jcenter仓库地址

### Gradle支持从maven中央仓库和JCenter上获取构件，那这两者有什么区别呢？
* maven中央仓库（http://repo1.maven.org/maven2/）是由Sonatype公司提供的服务，它是Apache Maven、SBT和其他构建系统的默认仓库，并能很容易被Apache Ant/Ivy、Gradle和其他工具所使用。开源组织例如Apache软件基金会、Eclipse基金会、JBoss和很多个人开源项目都将构件发布到中央仓库。 maven中央仓库已经将内容浏览功能禁掉了，可在http://search.maven.org/查询构件。
* jcenter中央仓库(https://jcenter.bintray.com ）是由JFrog公司提供的Bintray中的Java仓库。`它是当前世界上最大的Java和Android开源软件构件仓库`。所有内容都通过内容分发网络（CDN）使用加密https连接获取。JCenter是Goovy Grape内的默认仓库，Gradle内建支持（jcenter()仓库），非常易于在（可能除了Maven之外的）其他构建工具内进行配置。
JCenter相比mavenCenter构件更多，性能也更好。但还是有些构件仅存在mavenCenter中。

* 常见写法
			
		mavenCentral()别名，表示依赖是从Central Maven 2 仓库中获取的。
		jcenter()别名，表示依赖是从Bintary’s JCenter Maven 仓库中获取的。
		mavenLocal()别名，表示依赖是从本地的Maven仓库中获取的

* 仓库地址举例

		repositories {
	    	ivy {
	       	   url "http://ivy.petrikainulainen.net/repo"
	    	}
		}

		repositories {
    		maven {
        		url "http://maven.petrikainulainen.net/repo"
    		}
		}
		repositories {
   			 mavenCentral()
		}	
		repositories {//默认仓库
   			 jcenter()//它是当前世界上最大的Java和Android开源软件构件仓库
		}		

### 说说我们项目里面的gradle构建(项目有,模块有)_最重要
> 对于eclipse我们完全不懂ant也行,但是as需要简单看懂gradle脚本

* Gradle构建脚本（build.gradle）指定了一个`项目`和它的`任务`,分Project和Module两个级别的脚本文件
* Gradle属性文件（gradle.properties）用来配置构建属性。
* Gradle设置文件（gradle.settings）对于只有一个项目的构建而言是可选的，如果我们的构建中包含多于一个项目，那么它就是必须的，因为它描述了`哪一个项目参与构建`。每一个多项目的构建都必须在项目结构的根目录中加入一个设置文件。

### gradle依赖jar包有两种形式
1. 在线模式
	1. 本地仓库去找,去网络拉取
2. 离线模式
	1. 本地仓库去找,提示你关闭离线模式

### Gradle脚本常见3个错误
> 修改成自己电脑已有的版本即可

1. compileSdkVersion不存在
2. buildToolsVersion不存在
3. com.android.tools.build:gradle:1.3.0 不存在
4. 相关的依赖jar包找不到

### 实战_常用依赖
* 新建Module,删除Module
* 如何知道自己电脑里面有哪些v4,v7,v13版本
	* `{android sdk}\extras\android\m2repository\com\android\support`
* 导入v4,v7,v13-->offline
	* 本地
	* 仓库
* 导入.jar
	* 本地
	* 仓库
* 导入lib工程
* 存放.9图片

### 实战_整合svn
* 1.创建仓库 (C:\Program Files\TortoiseSVN\bin\svn.exe)
* 2.纳入svn管理
* 3.svn 添加忽略列表-->使用小乌龟
	* .gradle
	* .idea
	* .iml
	* local.propeties
	* build
	* module的build
	* module的.iml
	
* 4.提交相关的代码到svn仓库

* 5.svn checkout操作:拉取svn仓库上面的上面
	1.checkout下来的工程,如果没有`.idea`,as会把它当成一个普通的文件夹,关闭之后,重新导入即可

* 6.svn 的commit,update,merge操作
	1.冲突解决的3种情况(要么用别人,要么用自己,要么合并)
* 7.svn取消管理

### 删除module:
	 1,settings.gradle删了相应的模块 
 	 2,structure里去删除相应的模块 

### 加lib :
 	1,通过路径去导进来  
	2,直接复制过来,然后在settings.gradle里面添加相应的名字

### 快捷键
>熟悉常用快捷键

### 插件介绍
>下载地址:http://plugins.jetbrains.com/

	ADB Idea: 方便卸载apk,删除缓存
	Android ButterKnife Zelezny : ButterKnife对应的插件-->Generate

	Android Code Generator Plugin : 生成ViewHolder,生成initView方法
	Android Layout ID Converter: xml到控件的转换-->点相应的layout布局/convert Android layout xml	
	Android Studio Prettify: 帮助findViewById-->在setContentView()/Generate/View variables或fields

	Codota: 搜索代码块(去git上去搜索,然后有一些代码,让我们有参考) -->search Codota
	GsonFormat: jsonString自动转bean插件
	genymotion-idea-plugin: genymotion对应的插件
	SelectorChapek for Android: 帮助生成selector-->Generate Android selector
	Android Drawable Importer: 同一张图片生成多个自动生成多分辨率图片--> new /scaled Drawable
	Android Postfix Completion: toast和log加强,效果跟定义模版差不多.
	
	.ignore: git忽略文件高亮效果,文件夹颜色提示
	Eclipse Code Formatter: as可以使用eclipse code style
	Sexy Editor: 代码区域加背景(比如加美女图片背景)
	Android Parcelable code generator:生成Parcelable代码
	Gradle Dependencies Helper:gradle帮助插件
	Android Toolbox Plugin:生成ViewHolder,意义不大

### 实战_debug模式
1. 直接debug运行
2. 运行时进入debug
3. 掌握常见的操作
	
	f8:跳到下一个断点
	f6:运行到下一行
	f5:跳到方法里面去

### 加速Gradle的构建
1. 加大as内存
2. 在.gradle(本地仓库文件)文件夹创建gradle.properties配置一些全局的属性

		org.gradle.daemon=true
		org.gradle.jvmargs=-Xmx2048m -XX:MaxPermSize=512m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8
		org.gradle.parallel=true
		org.gradle.configureondemand=true
		#允许中文路径的项目
		com.android.build.gradle.overridePathCheck=true

