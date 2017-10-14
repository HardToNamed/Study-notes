#-- coding:utf-8 -- 
# 将文本转换为图片
import os
from PIL import Image, ImageFont, ImageDraw
width = 1000
height = 1000
im = Image.new("RGB", (width, height), "#FFFFFF")
dr = ImageDraw.Draw(im) #新建画布
fontsize = 30
linespace = 2
x,y = fontsize, fontsize + linespace #初始化
halffont = round(fontsize / 2)
font = ImageFont.truetype(os.path.join("fonts", "simsun.ttc"), fontsize) #指定字体
fill = "#FF34B3"
#font = ImageFont.truetype('msyh.ttf',12)
text = u"这是一段测试文本1，test 123。abcdefgaoiceoauvpapvaprvljaloaovpajlvjaljvoaurvajvljalrvlahvlalvhrlah"
for i in text:
    if(width <= x+fontsize*2 ):
        x = fontsize
        y += fontsize + linespace
    if(height < y + fontsize):
        height += 1000 # 扩展1000高度
        im1 = Image.new("RGB", (width, height), "#FFFFFF")
        im1.paste(im, (0,0, width,height-1000))
        im = im1
        dr = ImageDraw.Draw(im) #在新的图片上创建画布
    dr.text((x, y),i, font=font, fill=fill)
    #写完之后把x右移
    if(len(i) < len(i.encode())): #进入这个条件说明是中文
        x += fontsize
    else:
        x += halffont

#dr.text((20, 20), text, font=font, fill="#FF34B3")
#dr.multiline_text((36, 25), text, font=font, fill="#FF34B3")
print(dr.textsize(text, font=font))
#im.show()


#im.save("t.png")
#im1 = Image.new("RGB", (50, 50), "#FFFFFF")
#im.paste(im1, (0,100,0,150))
#dr = ImageDraw.Draw(im)
im.save("t.png")
