data, err := json.Marshal(movies) 生成紧凑的json对象

data, err := json.MarshalIndent(movies, "", "    ") 生成可读的json对象

Color bool `json:"color,omitempty"` 定义结构体时，color表示编辑为小写的字母，omitempty表示当结构体成员为空或零值时不生产json对象
