//
/BHY/LoginServlet:
    用户登陆的url
    参数：username（用户名）、password（密码）
    返回值：json格式：   key：   rtn
                        value： 1为登陆成功（会设置user到session中）应跳转到主页面
                                2为密码不正确，不跳转
                                3为用户名不存在，不跳转

//
/BHY/RegisterServlet:
    员工用户注册的url
    参数:   username 用户名
            password 密码
            e_name 员工姓名
            st_id 宠物店id（单选得到）
            d_id 职务id（单选得到）
    返回值：json格式：     key：    rtn
                          value：  1为注册成功，应跳转至登陆页面
                                   0为注册失败（用户名重复）

//
/BHY/FindUserLimitServlet:
    分页查询用户,会根据session中的user对象的类型判断是否能进行查询(通过判断user对象的d_id属性来得到当前用户的类型)
    参数：页码-
    返回值：json类型，如果当前状态为未登录，put("ifLogin", "false")并进行页面跳转
                      如果已登陆，put("isLord", "false")由前端进行提示
                      {"users":[
                                    {"d_id":9,"password":"litao.","u_id":1,"username":"li305193188"},
                                    {"d_id":9,"password":"123123123","u_id":2,"username":"zzwzzwzzw"},
                                    {"d_id":9,"password":"12345678","u_id":3,"username":"hahaha"},
                                    {"d_id":8,"password":"12341234","u_id":4,"username":"xiaogang"},
                                    {"d_id":8,"password":"qiangqinagqaing","u_id":5,"username":"xiaoqing"}
                                ]
                       }

//
/BHY/AddClientServlet:
    增加顾客信息的servlet
    参数：姓名 cl_name，手机 mobile, 用户id u_id全部设置为3[，年龄 cl_age，性别 cl_sex，邮箱cl_emil]
    返回值：若添加成功，返回{rtn:"1"}
          ：若添加失败，返回{rtn:"0"}（手机号重复）

//
/BHY/UpdateUserServlet:
    响应前端发送的更新用户信息（大概就是改密码。。。）的请求
    参数：需要传入用户名(username)和新密码(password)
    返回值：    修改成功返回rtn：1
                失败返回rtn：0（用户名不存在吧，一般前端规避这种错误，还有可能是数据库访问错误）

//
/BHY/FindPetLimitServlet：
    响应前台发来的分页查询宠物信息的请求
    参数：查询宠物条件和分页信息
    返回[
            {"cl_id":1,"cl_name":"小刚","d_id":30,"d_value":"短毛猫","p_age":0,"p_healthy":"","p_height":0,"p_id":1,"p_sex":"","st_address":"","st_id":1},
            {"cl_id":1,"cl_name":"小刚","d_id":33,"d_value":"橘猫","p_age":0,"p_healthy":"","p_height":0,"p_id":2,"p_sex":"","st_address":"","st_id":1},
            {"cl_id":1,"cl_name":"小刚","d_id":27,"d_value":"柯基","p_age":0,"p_healthy":"","p_height":0,"p_id":3,"p_sex":"","st_address":"","st_id":1},
            {"cl_id":2,"cl_name":"小强","d_id":28,"d_value":"萨摩耶","p_age":0,"p_healthy":"","p_height":0,"p_id":4,"p_sex":"","st_address":"","st_id":3},
            {"cl_id":2,"cl_name":"小强","d_id":28,"d_value":"萨摩耶","p_age":0,"p_healthy":"","p_height":0,"p_id":5,"p_sex":"","st_address":"","st_id":3}
        ]
    返回一个json，其中各个字段对应pet的详细信息

//
/BHY/AddPetServlet：
    添加一条宠物信息
    参数： 宠物品种 d_id，顾客手机号 mobile，宠物店id s_id(不需要提供，后台根据登陆用户查询)[，年龄 p_age，性别 p_sex，体重 p_height]
    返回值：添加成功返回rtn：1，否则返回rtn：0

//
/BHY/FindClientLimitServlet:
    [分页][条件]查询顾客信息
    参数：顾客信息和页码
    返回值：[
                {"cl_age":0,"cl_emil":"","cl_id":1,"cl_name":"小刚","cl_sex":"","mobile":"13712341234","u_id":4},
                {"cl_age":0,"cl_emil":"","cl_id":2,"cl_name":"小强","cl_sex":"","mobile":"13956785678","u_id":5}
            ]

//
/BHY/FindStoreLimitServlet:
    [分页][条件]查找宠物店信息
    参数：查询条件和分页信息
    返回值：[
                 {"d_id":16,"d_value":"总店","e_id":0,"e_name":"","st_address":"","st_id":1,"st_time":null},
                 {"d_id":17,"d_value":"省店","e_id":0,"e_name":"","st_address":"","st_id":2,"st_time":null},
                 {"d_id":18,"d_value":"市店","e_id":0,"e_name":"","st_address":"","st_id":3,"st_time":null}
            ]

//
/BHY/FindEmployeeLimitServlet:
    [分页][条件]查询员工信息
    参数：查询条件和分页
    返回值：[
                 {"d_id":43,"d_value":"服务员","e_age":0,"e_id":1,"e_name":"A","e_salary":3000,"e_sex":"","e_time":null,"st_address":"","st_id":3,"u_id":0,"username":""},
                 {"d_id":42,"d_value":"医师","e_age":0,"e_id":2,"e_name":"B","e_salary":4000,"e_sex":"","e_time":null,"st_address":"","st_id":2,"u_id":0,"username":""},
                 {"d_id":41,"d_value":"店长","e_age":0,"e_id":3,"e_name":"C","e_salary":5000,"e_sex":"","e_time":null,"st_address":"","st_id":1,"u_id":0,"username":""},
                 {"d_id":42,"d_value":"医师","e_age":0,"e_id":4,"e_name":"D","e_salary":4000,"e_sex":"","e_time":null,"st_address":"","st_id":2,"u_id":0,"username":""}
            ]

//
/BHY/FindRecordLimitServlet:
    [分页][条件]查询销售记录的详细信息
    参数：查询条件和分页条件
    返回值：[
                 {"c_id":1,"c_name":"狗粮","cl_id":1,"cl_name":"小刚","r_id":1,"r_num":1,"r_pattern":"","r_price":150,"r_time":
                            {"date":25,"day":6,"hours":2,"minutes":0,"month":4,"seconds":0,"time":1558720800000,"timezoneOffset":-480,"year":119},"st_address":"","st_id":1},
                 {"c_id":1,"c_name":"狗粮","cl_id":1,"cl_name":"小刚","r_id":3,"r_num":1,"r_pattern":"","r_price":150,"r_time":
                            {"date":5,"day":0,"hours":22,"minutes":0,"month":4,"seconds":0,"time":1557064800000,"timezoneOffset":-480,"year":119},"st_address":"","st_id":1},
                 {"c_id":3,"c_name":"疫苗","cl_id":2,"cl_name":"小强","r_id":2,"r_num":1,"r_pattern":"","r_price":300,"r_time":
                            {"date":25,"day":6,"hours":1,"minutes":0,"month":4,"seconds":0,"time":1558717200000,"timezoneOffset":-480,"year":119},"st_address":"","st_id":3}
            ]

//
/BHY/FindCargoLimitServlet:
    [分页][条件]查询货物信息
    参数：货物查询信息和分页信息
    返回值：json数组
         [
            {"c_expirationDate":null,"c_getDate":null,"c_id":1,"c_name":"狗粮","c_num":200,"c_producedDate":null,"d_id":13,"d_value":"饲料","st_id":1,"st_name":""},
            {"c_expirationDate":null,"c_getDate":null,"c_id":2,"c_name":"猫粮","c_num":100,"c_producedDate":null,"d_id":13,"d_value":"饲料","st_id":2,"st_name":""},
            {"c_expirationDate":null,"c_getDate":null,"c_id":3,"c_name":"疫苗","c_num":50,"c_producedDate":null,"d_id":14,"d_value":"医疗用具","st_id":3,"st_name":""}
         ]

//
/BHY/FindServiceLimitServlet:
    [分页][条件]查询服务项信息
    参数：查询条件和分页
    返回值：[
             {"d_id":37,"d_value":"看病","e_id":0,"e_name":"","p_id":1,"s_atime":null,"s_id":1,"s_isdispose":"true","s_isfinish":"true","s_price":0},
             {"d_id":38,"d_value":"体检","e_id":0,"e_name":"","p_id":3,"s_atime":null,"s_id":2,"s_isdispose":"false","s_isfinish":"false","s_price":0},
             {"d_id":38,"d_value":"体检","e_id":0,"e_name":"","p_id":4,"s_atime":null,"s_id":3,"s_isdispose":"true","s_isfinish":"false","s_price":0}
            ]

//
/BHY/UpdatePetServlet:
    更新一条宠物信息
    p_id为检索信息，其他为更新信息，包括st_id， p_age， p_sex， p_height， p_healthy， cl_id
    更新成功返回rtn：1， 失败返回rtn：0

//
/BHY/DeletePetServlet:
    删除一条宠物信息,宠物被连接的外键需要被清空（服务）
    参数：p_id
    删除成功返回rtn：1， 否则rtn：0

//
/BHY/AddServiceServlet：
    插入一条服务项信息
    插入的服务信息必须要提供宠物id， 字典id（服务类型）， 员工id
    插入成功返回rtn:1，否则返回rtn:0

//
/BHY/UpdateServiceServlet:
    更新服务项内容
    serviceCustom s_id作为见多信息，其他都为要修改的新信息,宠物id， 字典id（服务类型）不为空
    更新成功返回rtn:1，否则返回rtn:0

//
/BHY/DeleteServiceServlet:
    删除一条服务项信息
    只需要s_id字段
    删除成功返回rtn:1，否则返回rtn:0

//
/BHY/AddRecordServlet:
    添加一条销售单信息，回返r_id
    必须包括顾客手机号码，登陆状态，c_id前端下拉菜单（或通过点击货物进入下单页面），当前时间，售出价格，购买数量
    插入成功返回rtn:1，否则返回rtn:0

//
/BHY/UpdateRecordServlet:
    更新一条销售记录，r_id为查找索引，其他信息都为更新信息
    可以更改的信息：销售物品（c_id）销售时间（r_time），销售金额（r_price），销售数量（r_num），支付方式（r_pattern）
    更新成功返回rtn:1，否则返回rtn:0

//
/BHY/DeleteRecordServlet:
    删除一条销售记录
    要删除的销售记录信息，只需要填充r_id字段
    删除成功返回rtn:1，否则返回rtn:0

//
/BHY/AddStoreServlet:
    添加一条宠物店信息
    新建的宠物店信息，必须填充d_id(宠物店类型，前端下拉列表获得)字段
    插入成功返回true，否则返回false

//
/BHY/UpdateStoreServlet:
    更新一条宠物店信息
    更新的信息，st_id为检索信息，其他字段都为更改后的新信息
    成功返回rtn:1，否则返回rtn:0

//
/BHY/DeleteStoreServlet:
    删除一条宠物店信息
    要进行删除的宠物店的信息，其中st_id必须被填充,并且st_id字段不能被其他表的外键关联
    删除成功返回rtn:1，否则返回rtn:0

//
/BHY/UpdateEmployeeServlet:
    更新员工信息
    参数：包装更新信息，e_id为检索信息，其他为更新信息
          可以更新的信息：姓名e_name，工资e_salary，所属宠物店st_id，职务d_id，年龄e_age
          更新成功返回rtn:1，否则返回rtn:0

//
/BHY/DeleteEmployeeServlet:
    删除一条员工信息
    要删除的员工的信息，只需要填充e_id字段
    删除成功返回rtn:1，否则返回rtn:0

//
/BHY/UpdateClientServlet:
    更新一条顾客信息
    cl_id为检索信息，其他为更新信息
    更新成功返回true，否则返回false

//
/BHY/FindDicByParValueServlet：
    根据父节点的value查找其子结点
    参数：查询信息，只需要填充d_value字段
    返回值：[
                 {"d_name":"dog","d_par_id":19,"d_id":22,"d_value":"杂种狗"},
                 {"d_name":"dog","d_par_id":19,"d_id":25,"d_value":"哈士奇"},
                 {"d_name":"dog","d_par_id":19,"d_id":26,"d_value":"阿拉斯加"},
                 {"d_name":"dog","d_par_id":19,"d_id":27,"d_value":"柯基"},
                 {"d_name":"dog","d_par_id":19,"d_id":28,"d_value":"萨摩耶"},
                 {"d_name":"dog","d_par_id":19,"d_id":29,"d_value":"泰迪"}
            ]

//
/BHY/FindDicLimitServlet:
    分页查询字典信息
    只需要填充分页信息 page = ?
    返回值：[
                 {"d_name":"dog","d_par_id":19,"d_id":22,"d_value":"杂种狗"},
                 {"d_name":"cat","d_par_id":20,"d_id":23,"d_value":"杂种猫"},
                 {"d_name":"dog","d_par_id":19,"d_id":25,"d_value":"哈士奇"},
                 {"d_name":"dog","d_par_id":19,"d_id":26,"d_value":"阿拉斯加"},
                 {"d_name":"dog","d_par_id":19,"d_id":27,"d_value":"柯基"},
                 {"d_name":"dog","d_par_id":19,"d_id":28,"d_value":"萨摩耶"},
                 {"d_name":"dog","d_par_id":19,"d_id":29,"d_value":"泰迪"},
                 {"d_name":"cat","d_par_id":20,"d_id":30,"d_value":"短毛猫"},
                 {"d_name":"cat","d_par_id":20,"d_id":31,"d_value":"布偶猫"},
                 {"d_name":"cat","d_par_id":20,"d_id":32,"d_value":"加菲猫"},
                 {"d_name":"cat","d_par_id":20,"d_id":33,"d_value":"橘猫"},
                 {"d_name":"medical","d_par_id":6,"d_id":34,"d_value":"医疗"},
                 {"d_name":"clean","d_par_id":6,"d_id":35,"d_value":"清洁"},
                 {"d_name":"medical","d_par_id":34,"d_id":36,"d_value":"疫苗注射"},
                 {"d_name":"medical","d_par_id":34,"d_id":37,"d_value":"看病"},
                 {"d_name":"medical","d_par_id":34,"d_id":38,"d_value":"体检"},
                 {"d_name":"clean","d_par_id":35,"d_id":39,"d_value":"洗澡"},
                 {"d_name":"clean","d_par_id":35,"d_id":40,"d_value":"剪指甲"},
                 {"d_name":"EmplpyeeType","d_par_id":7,"d_id":41,"d_value":"店长"},
                 {"d_name":"EmplpyeeType","d_par_id":7,"d_id":42,"d_value":"医师"}
           ]





































！！！！！！！！！！！！！！！！！！！！！！！！
        关于宠物店的连接查询填充字段
！！！！！！！！！！！！！！！！！！！！！！！！

        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //设置输出
        PrintWriter pw = response.getWriter();
        JSONObject jsonObject = new JSONObject();

        //封装数据

        //调用业务逻辑

        //输出
        pw.print(jsonObject);
        pw.close();


            //封装数据
            //注册转换器
            DateConverter dateConverter = new DateConverter();
            //设置日期格式
            dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            //注册格式
            ConvertUtils.register(dateConverter, Date.class);
