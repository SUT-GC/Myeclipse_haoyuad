###浩宇广告公司数据库设计

* hyad_admin

| 字段  | 类型 | 主键 | 外键 | NULL | 备注 |
|:-----|:-----|:----|:----|:-----|:-----|
|admin_id| int | Y | N | N | (1) |
|admin_name| varchar(20)|N|N|N|(2)|
|admin_account|varchar(20)|N|N|N|(3)|
|admin_pass|varchar(40)|N|N|N|(4)|
|admin_power|int|N|N|N|(5)|

> (1) 用来填写用户id， 设置为自增长    
> (2) 用来保存用户姓名    
> (3) 用来保存用户的账号    
> (4) 用来保存密码(md5)     
> (5) 用来设置用户权限（0 : 普通管理员 ,1: 超级管理员)    

***

* hyad_label

| 字段  | 类型 | 主键 | 外键 | NULL | 备注 |
|:-----|:-----|:----|:----|:-----|:-----|
|label_id|int|Y|N|N|(1)|
|label_name|varchar(20)|N|N|N|(2)|

> (1) 用来填写标签的id， 设置为自增长    
> (2) 用来保存标签的名称    

***

* hyad_case

| 字段  | 类型 | 主键 | 外键 | NULL | 备注 |
|:-----|:-----|:----|:----|:-----|:-----|
|case_id|int|Y|N|N|(1)|
|case_name|varchar(20)|N|N|N|(2)|
|case_describe|varchar(225)|N|N|N|(3)|
|case_headimg|varchar(225)|N|N|N|(4)|
|case_images|varchar(225)|N|N|N|(5)|
|case_createtime|date|N|N|N|(6)|
|case_show|int|N|N|N|(7)|

> (1) 用来保存案例id， 设置自增长    
> (2) 用来保存案例名称（base64）    
> (3) 用来保存案例描述（base64）    
> (4) 用来保存案例首图（base64）    
> (5) 用来保存案例展示图片（base64），每张图片编码 & 作为间隔    
> (6) 用来保存案例创建时间    
> (7) 用来确定该案例是否显示在首页    

***

* hyad_label_case

| 字段  | 类型 | 主键 | 外键 | NULL | 备注 |
|:-----|:-----|:----|:----|:-----|:-----|
|label_case_id|int|Y|N|N|(1)|
|label_id|int|N|Y|N|(2)|
|case_id|int|N|Y|N|(3)|


>(1) 用来保存标签与案例结合的记录id，自增长    
>(2) 用来保存标签id    
>(3) 用来保存案例id    

***



