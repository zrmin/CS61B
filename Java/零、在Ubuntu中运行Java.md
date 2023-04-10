<h1><center>零、在Ubuntu中运行Java</center></h1>

### 一、安装Java环境

1. `sudo apt-get update`
2. `sudo apt-get install default-jdk`
   * 在CS61B环境配置中，我安装的jdk版本不是这个版本
3. `javac --version`
   * 我的返回`11.0.18`

### 二、写代码并运行

1. 写一个代码`HelloWorld.java`

   ```Java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello World\n");
       }
   }
   ```

2. `javac HelloWorld.java`

   * `javac`是java的编译器，会生成`HelloWorld.class`字节码文件

3. `java HelloWorld`

   * `java`是java的解释器，会解释执行字节码文件