<h1><center>CS61B环境配置</center></h1>

<center><h3>Ubuntu运行java及基本环境配置</h3></center>

1. 安装jdk9

   * `sudo apt-get -o Dpkg::Options::="--force-overwrite" install openjdk-9-jdk`

2. 安装Python3

   * `sudo apt-get install python3`
   * `python3 -i`

3. 安装Git

   * `sudo apt-get install git`
   * `git --version`

   <h3><center>CS61B Github配置</center></h3>

### 一、新建仓库

![image-20230410082224635](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100822797.png)

### 二、配置SSH Key

没有Windows的Git Bash，要先下载Windwos的Git Bash。

如果之前没有配置过SSH Key，可以看这篇[博客](https://www.cnblogs.com/yuqiliu/p/12551258.html)。

我之前配置过SSH Key，但是验证的时候发现验证失败，所以又重新把之前生成的SSH Key传到GitHub上面了。

1. `cat ~/.ssh/id_rsa.pub`

2. 复制

3. 粘贴到GitHub的SSH Key中

4. 验证是否成功`ssh -T git@github.com`

   ![image-20230410083211050](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100832112.png)

### 三、建立本地仓库

在自己的电脑上新建一个和GitHub上面名字一样的文件夹。然后执行`git init`初始化仓库。

![image-20230410083705581](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100837619.png)

1. `git add .`
2. `git commit -m "start CS61B"`
3. `vim README.md`
4. `git add .`
5. `git commit -m "add readme"`

### 四、推送到Github上面

当我们在Github上面创建完仓库以后，github跳转到的界面会提示我们要怎么做，我们按照这个来：

![image-20230410084456460](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100844509.png)

刷新一下Github，发现仓库现在已经和我们的本地仓库同步了。

![image-20230410084728752](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100847829.png)

### 五、获取Skeleton代码

在Git Bash中执行`git pull https://github.com/Berkeley-CS61B/skeleton-sp18.git`

![image-20230410085500888](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100855956.png)

遇到`fatal: refusing to merge unrelated histories`

解决方案：`git pull --rebase --allow-unrelated-histories xxxx`



`git push`一下。

可能提示一些问题，根据hint输入相应的命令即可，比方说像`git pull`、`git pull --rebase --allow-unrelated-histories`之类的。

![image-20230410090740790](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100907834.png)

### 附录

很奇妙的事情，我git push后，我新建的这个仓库突然有了18个contributor。

![image-20230410092540136](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100925260.png)

好奇妙，我不知道为什么。