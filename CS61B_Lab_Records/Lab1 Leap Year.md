<h1><center>Lab1 Leap Year</center></h1>

进入lab1文件夹，`vim LeapYear.java`。

这是一个判断闰年的程序，闰年需要满足两个条件：

1. 能被400整除，或者
2. 能被4整除，但是不能被100整除

添加的代码如下：

```Java
public static boolean isLeapYear(int year) {
       if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) 
           return true;
        else 
            return false;
        }
```

编译、运行并测试：

![image-20230410093141055](https://raw.githubusercontent.com/zrmin/BlogImages/master/images/202304100931112.png)