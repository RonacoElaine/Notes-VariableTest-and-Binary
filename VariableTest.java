/*
2-3 变量：包含变量类型（Java需要明确指出类型，因此属于强类型语言）、变量名和存储的值
1. Java定义变量的形式：数据类型 变量名 = 变量值；
2. 说明：
>变量必须先声明，后使用
>使用变量名来访问这块区域的数据
>变量都定义在其作用域内，在作用域内，他是有效的
>同一个作用域内，不可以声明两个同名的变量
3. 变量的分类：2种分类的方法
3.1 Java定义的数据类型：8种基本+3种引用
（1）变量按照数据类型来分：基本数据类型（primitive)和引用数据类型(reference)
（2）Primitive：数值型-整数（byte,short,int,long)&浮点(float,double)，字符型char，布尔型boolean;
（3）Reference：类class-字符串,接口interface,数组[]
3.1.1 >>整数：
byte-1字节=8bit位：-128 ~ 127
short-2字节: -32768 ~ 32767（-2的15次方~2的15次方-1）
int-4字节: -2147483648 ~ 2147483647（-2的31次方~2的31次方-1）
long-8字节: -9223372036854775808 ~ 9223372036854775807（-2的63次方~2的63次方-1）
*声明long类型，数字后要加L/l：long l1=4001001111L；
*通常定义整型变量时，使用int型
3.1.2 >>浮点：
浮点类型的数就是小数，因为小数用科学计数法表示的时候，小数点是可以“浮动”的，如1234.5可以表示成12.345x102，也可以表示成1.2345x103，所以称为浮点数。
float f1 = 3.14f;
float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
double d = 1.79e308;
double d2 = -1.79e308;
double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324

float-4字节：-3.403E38~3.403E38，单精度，尾数可以精确到7位有效数字(整数位+小数位），很多情况下，精度很难满足需求；
*float表示数值的范围比long还大，定义float类型变量时，变量要以f/F结尾；
*double-8字节：-1.798E308~1.798E308，双精度，精度是float的两倍（整数位+小数位，15位以内），通常定义浮点型，使用double。

3.1.3 >>字符型char-1字符=2字节:声明一个字符

3.1.4 >>布尔型boolean:只能取两个值之一（true/false),常用于条件判断、循环结构

>变量在类中声明的位置：成员变量 vs 局部变量 (后续会讲）
>>>字符集：ASCII码-英语字符和二进制之间的关系，ASCII规定了128种。比如空格space是32（二进制00100000）
Unicode编码--->>UTF-8

 */

class VariableTest {
    public static void main(String[] args){

        int myAge = 25;//变量的定义
        System.out.println(myAge);//变量的使用

        int myNumber;
        myNumber = 2147483647;
        System.out.println(myNumber);
        //这里我之前用的数字是4001001111，编译不了，原因如下：
        // 对于整型类型，Java只定义了带符号的整型，因此，最高位的bit表示符号位（0表示正数，1表示负数）。各种整型能表示的最大范围如下：
        //byte-1字节=8bit位：-128 ~ 127
        //short-2字节: -32768 ~ 32767（-2的15次方~2的15次方-1）
        //int-4字节: -2147483648 ~ 2147483647（-2的31次方~2的31次方-1）
        //long-8字节: -9223372036854775808 ~ 9223372036854775807（-2的63次方~2的63次方-1）

        long l1 = 4001001001L;
        System.out.println(l1);

        double d1 = 1.5698948018;
        System.out.println(d1+1);

        float f1 = 3.1415926f;
        System.out.printf("%.12f", f1-1);
        System.out.println();
        double d2 = 3.1415926;
        System.out.println(d2-1);

        //定义char型，通常使用单引号,内部只能写一个字符（语言不限）
        char c1 = 'a';
                c1 = 'A';
                c1 = '1';
                c1 = '秋';
        System.out.println(c1);
                //表示方式：1. 声明一个字符；2. 转义字符 3. 直接使用Unicode值来表示常量
        char c2 = '\n';//换行符
        c2 = '\t';//制表符
        System.out.print("hello" + c2 );
        System.out.println("world");
        char c3 = '\u0043';
        System.out.println(c3);

        boolean bb1 = false;
        System.out.println(bb1);
        //条件判断的例子
        boolean iscool = true;
        if(iscool){
            System.out.println("show me the \"money\"");//强调某句想要使用“”，需要各自在"前加个\
        }else{
            System.out.println("bye bye");
        }

/*
3.2 基本数据类型之间的运算规则
前提：除了boolean型之外的7种，可以互相做运算
3.2.1 >>>自动类型提升：byte short int long float double(容量渐大，容量指的是表示数的范围的大小)
当容量小的变量与容量大的变量做运算时，结果自动提升为容量大的类型
But how about char? ***byte、char、short三种类型中无论哪两种做运算，结果都需要用int定义。
整型常量默认为int,例如数字1；浮点型常量默认为double

*/
        byte b10 = 1;
        int i10 = 199;
        //这里不可以再用byte作为结果的变量表达；
        int i11 = b10+i10;
        System.out.println(i11);
        double d11 = i11;
        System.out.println(d11);
        char c10 = 'a';//a=97
        int i12 = 10;
        int i13 = c10+i12;
        System.out.println(i13);

/*
3.2.2 >>>强制类型转换：自动类型提升的逆运算
需要使用强转符()，可能导致精度损失
long型定义的变量，不加l会被默认为int，如果在int范围内即可运算；float定义的变量，不加f会被默认为double，无法运行，因为double转float是强制类型转换
*/

        double d12 = 12.9;
        int i14 = (int)d12;//（要转换的类型），截断尾数强制转换,可能会损失精度
        System.out.println(i14);
        long l14 = 123l;
        short s14 = (short)l14;
        System.out.println(s14);
        //精度损失举例：
        int i15 = 159;
        byte b15 = (byte)i15;
        System.out.println(b15);

 /* 3.3 引用数据类型Spring的使用：字符串，声明变量时需要用""
String可以和8种基本数据类型做运算（包括char),且只能做连接运算：+(拼在一起），运算结果也为String类型。


 */
        String s1 = "Hello World!";
        System.out.println(s1);

//Exercise Part

        int number1 = 1001;
        String numberStr = "学号：";
        String info = numberStr + number1;
        System.out.println(info);
        //练习题1；
        char c20 = 'a';//a=97
        int number = 10;
        String str = "hello";
        System.out.println(c20+number+str);//107hello
        System.out.println(c20+str+number);//ahello10
        System.out.println(str+number+c20);//hello10a
        //练习题2：如何输入* *(除了直接打印“* *“）
        //Solution 1：
        char c21 = '*';
        String s21 = " ";
        System.out.println(c21+s21+c21);
        //Solution 2/3:
        System.out.println('*'+"\t"+'*');
        System.out.println('*'+('\t'+"*"));

        String st2 = 3.5f + "";
        System.out.println(st2);

        //String sfalse22 = 123;
        //编译不通过,Srring类型必须要用""
        String s22 = 123+"";
        System.out.println(s22);//输出其实是”123“，但是打印的时候会去掉""
        //int ifalse22 = (int)s22;
        //不可进行这样的转换；要通过如下公式转换
        int number22 = Integer.parseInt(s22);
        System.out.println(number22);


        }


}

