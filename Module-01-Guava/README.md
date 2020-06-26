# guava相关使用

主要包含如下5个部分的guava练习,都在test文件夹下

## utilities   实用工具

Joiner:         拼接集合中的元素  
Splitter:       分割字符串  
Preconditions:  判断结果  
charMatcher:    对字符的匹配操作  
Strings:        对字符串的操作,判空,重复,取共同前缀后缀,填充字母  
Collections:    对基本类型集合的操作,Bytes/Shorts/Ints/Longs/Floats/Doubles/Chars/Booleans  
multi-:         可重复key的集合,multiSet multiMap  
ImmutableCollection:    不可变集合,ImmutableList/ImmutableSet/ImmutableSortedSet/ImmutableMap  
BiMap:          双向关联队列  
hashBasedTable: 复合索引表格,<row,column,value>  

## functional  函数式编程

对函数式编程的一些扩展

## io          文件操作

前缀: `Files.method...`  
其中`source`用于读取  
`sink`用于写入    
nio没有研究  

## eventBus    

消息队列,本地的事件中间件

## cache

本地的缓存,适用于频繁读取的少量数据