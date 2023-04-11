<h1><center>Proj0问题记录</center></h1>

1. `Doube.parseDouble(args[0])`，不是`parseDouble(args[0])`

2. `.\StdDraw.java:299：错误：编码GBK的不可映射字符`

   > 由于JDK是国际版的，在编译的时候，如果我们没有用`-encoding`参数指定我们的Java源程序的编码格式，则`javac.exe`首先获得我们**操作系统默认采用的编码格式**。
   >
   > 在编译Java程序时，若我们不指定源程序文件的编码格式：
   >
   > * JDK首先获得操作系统的`file.encoding`参数（它保存的就是操作系统默认的编码格式，如`WIN2k`，它的值为`GBK`
   > * JDK把我们的Java源程序从`file.encoding`编码格式转化为Java内部默认的`UNICODE`格式放入内存中
   > * `javac`把转换后的unicode格式的文件进行编译，生成.class字节码文件，此时的.class文件是**UNICODE**编码的
   >
   > 对于我们来说，我们最终获得的.class文件的内容是以**UNICODE**编码格式保存的字节码文件，它内部包含我们源程序中的中文字符串，只不过此时它已经由`file.encoding`格式转化为**UNICODE**格式了。当我们不加设置就编译时，相当于使用了参数：`javac -encoding gbk NBody.java`，当然会出现不兼容的情况。

   * 解决方法：`javac -encoding utf-8 NBody.java`

3. markdown中引入的用法：在一行前输入`>`，然后空格一下就ok了。

4. 