## css基础

h1 {color:red; font-size:14px;}

.center {text-align: center}类选择器
#red {color:red;}id选择器

  p.uppercase {text-transform: uppercase}
  p.lowercase {text-transform: lowercase}
  p.capitalize {text-transform: capitalize}类选择器应用
  
## CSS样式-背景

background-color背景颜色
padding内边距
background-image背景图片
background-repeat: no-repeat背景图片不重复

background-attachment:fixed;设此值时背景图片不随其他元素移动

background-position: 50% 50%; 按百分比定位图片的位置（x px y px表示按x、y轴px为单位定位图片位置）

## CSS样式-文本

<span></span>定义一个行内元素，用划分一行成不同区域，实现其他效果

text-decoration多用于去掉链接的下划线

text-indent:5em;首行缩进5em（1em等于1字宽）

text-align 对齐, left、right、center，justify两端对齐

word-spacing字间隔
letter-spacing字母间隔

text-transform字符转换，uppercase、lowercase，capitalize首字母大写

white-space: normal忽略多个换行符和空白符


font-family: sans-serif;选择一个通用字体
font-style字体风格，italic 斜体
font-weight加粗，100-900,400为正常字体
font-size字体大小：默认16px=1em，单位px或em

## CSS样式-链接


a:link {text-decoration:none;}    /* 未被访问的链接 */
a:visited {text-decoration:none;} /* 已被访问的链接 */
a:hover {text-decoration:underline;}   /* 鼠标指针移动到链接上 */
a:active {text-decoration:underline;}  /* 正在被点击的链接 */

## CSS样式-列表

ul.disc {list-style-type: disc}
ul.circle {list-style-type: circle}
ul.square {list-style-type: square}
ul.none {list-style-type: none}无序列表中不同的列表标记

ol.decimal {list-style-type: decimal}
ol.lroman {list-style-type: lower-roman}
ol.uroman {list-style-type: upper-roman}
ol.lalpha {list-style-type: lower-alpha}
ol.ualpha {list-style-type: upper-alpha}有序列表中不同的列表标记

list-style-image: url('/i/eg_arrow.gif')将图像作为列表标记

## 表格

 border-collapse:collapse;折叠边框，即只有一条线
height、width表格的高宽
border: 1px solid blue;蓝色边框


示例
<style type="text/css">
#customers
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#customers td, #customers th 
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#customers th 
  {
  font-size:1.1em;
  text-align:left;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#customers tr.alt td 
  {
  color:#000000;
  background-color:#EAF2D3;
  }
</style>
