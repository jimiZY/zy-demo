package cn.cocopup.zy.rocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zy
 * @create 2019-09-19 16:37
 */
public class Gencode {


    /**
     * 手机号脱敏筛选正则
     */
    public static final String PHONE_BLUR_REGEX = "(\\d{3})\\d{4}(\\d{4})";

    /**
     * 手机号脱敏替换正则
     */
    public static final String PHONE_BLUR_REPLACE_REGEX = "$1****$2";

    @Test
    public void genCode() {

        String moduleName = "case";

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zouyong");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");    //去掉Service接口的首字母I
        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(true);//开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.199.185:3306/zy_" + moduleName);
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("lysrv");
        dsc.setPassword("Abc123,./");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(moduleName); //模块名
        pc.setParent("cn.cocopup.zy.rocket");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setInclude(moduleName + "_\\w*");//设置要映射的表名
        strategy.setInclude("case_task_view", "task_assign_view", "tec_leader_view");


        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        //strategy.setTablePrefix("ly_");//设置表前缀不生成
        //strategy.setFieldPrefix("rcla_"); //设置字段前缀不生成

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除字段名
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀

        //自动填充
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        // strategy.setVersionFieldName("version");//乐观锁列

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }


    @Test
    public void test() {
        HashSet<String> set = new HashSet<>();
        set.add("zouyong");
        set.add("lina");
        set.add("yangtian");
        set.add("zouyong");
        System.out.println(set);
        System.out.println(set.iterator().next());
    }


    @Test
    public void testList() {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        Map<String, List<String>> map = new HashMap<>();
        map.put("one", list);

        List<String> list1 = map.get("one");
        list1.add("ddd");

        System.out.println(map);


    }

    @Test
    public void testJson() {
        DemoTestClass demoTestClass = new DemoTestClass();
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        DemoTestClass demoTestClass1 = demoTestClass.setName("zouyogn").setList(list);

        String s = JSON.toJSONString(demoTestClass1);
        System.out.println(s);

    }


    @Test
    public void testCollections() {

        List<String> list = new ArrayList<>();
        list.add("add");
        list.add("bb");
        list.add("vv");
        list.add("ccc");
        list.add("");
        list.add(" ");
        list.add("  ");
        list.add("zzzz");

        list.stream().forEach(System.out::println);
        System.out.println("=====================");
        list.stream().filter(userId -> StringUtils.isNotBlank(userId)).forEach(System.out::println);


    }

    @Test
    public void testList2() {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("zouyong");
        list1.add("zouyong2");
        list1.add("zouyong3");
        list1.add("zouyong4");
        list1.add("zouyong5");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("zouyong");
        list2.add("zouyong3");
        list2.add("zouyong4");
        list2.add("zouyong2");
        list2.add("zouyong6");

        boolean b = list1.containsAll(list2);
        System.out.println(b);

    }


    @Test
    public void testList3() throws InterruptedException {

        ArrayList<DemoTestClass> list = new ArrayList<>();

        Date date1 = new Date();
        System.out.println(date1);
        DemoTestClass demoTestClass1 = new DemoTestClass().setDate(date1);
        Thread.sleep(1000);
        Date date2 = new Date();
        System.out.println(date2);
        DemoTestClass demoTestClass2 = new DemoTestClass().setDate(date2);
        Thread.sleep(1000);
        Date date3 = new Date();
        System.out.println(date3);
        DemoTestClass demoTestClass3 = new DemoTestClass().setDate(date3);
        Thread.sleep(1000);
        Date date4 = new Date();
        System.out.println(date4);
        DemoTestClass demoTestClass4 = new DemoTestClass().setDate(date4);

        list.add(demoTestClass1);
        list.add(demoTestClass2);
        list.add(demoTestClass3);
        list.add(demoTestClass4);


        List<DemoTestClass> collect = list.stream().filter(vo -> !vo.getDate().before(date2)).filter(vo -> !vo.getDate().after(date4)).collect(Collectors.toList());

        System.out.println(collect);


    }

    @Test
    public void test4() {
        List<DemoTestClass> list = Arrays.asList(new DemoTestClass().setName("1111").setDate(new Date()),
                new DemoTestClass().setName("222").setDate(new Date()),
                new DemoTestClass().setName("333").setDate(new Date()));

        list.forEach(demo ->
        {
            if(demo.getName().endsWith("1")){
               demo.setName(demo.getName().replace("1","一"));
            }
        });

        System.out.println(list);

    }

    @Test
    public void tet5(){

        List<String> list = Arrays.asList("a", "b", "c", "d", "e");

        String collect = list.stream().collect(Collectors.joining(",","zou,",",yong"));

        System.out.println(collect);

    }


    @Test
    public void testOptional(){
        DemoTestClass demo = new DemoTestClass().setName("zouyong");

        Optional<DemoTestClass> optional = Optional.of(demo);
        System.out.println(optional.isPresent() ? optional.get() : "空的");

        Optional<List<String>> list = Optional.ofNullable(demo.getList());
        System.out.println(list.isPresent() ? list.get() : "空的list");

        Optional.ofNullable(demo.getName()).ifPresent(System.out::println);

    }

    @Test
    public void testMaps(){
        List<TestClass2> list1 = new ArrayList<>();
        list1.add(new TestClass2().setId(1).setName("一").setNumber(10));
        list1.add(new TestClass2().setId(2).setName("二").setNumber(20));
        list1.add(new TestClass2().setId(3).setName("三").setNumber(30));
        list1.add(new TestClass2().setId(6).setName("六").setNumber(60));
        list1.add(new TestClass2().setId(7).setName("77").setNumber(70));

        List<TestClass2> list2 = new ArrayList<>();
        list2.add(new TestClass2().setId(1).setName("一").setNumber(10));
        list2.add(new TestClass2().setId(2).setName("二").setNumber(20));
        list2.add(new TestClass2().setId(4).setName("三").setNumber(40));
        //list2.add(new TestClass2().setId(6).setName("六").setNumber(66));
        //list2.add(new TestClass2().setId(7).setName("七").setNumber(77));

        Map<Integer, List<TestClass2>> map1 = list1.stream().collect(Collectors.groupingBy(TestClass2::getId));
        Map<Integer, List<TestClass2>> map2 = list2.stream().collect(Collectors.groupingBy(TestClass2::getId));

        MapDifference<Integer, List<TestClass2>> difference = Maps.difference(map1, map2);
        Map<Integer, List<TestClass2>> inCommon = difference.entriesInCommon();
        Map<Integer, MapDifference.ValueDifference<List<TestClass2>>> integerValueDifferenceMap = difference.entriesDiffering();
        for (Map.Entry<Integer, MapDifference.ValueDifference<List<TestClass2>>> entry : integerValueDifferenceMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        Map<Integer, List<TestClass2>> onlyOnLeft = difference.entriesOnlyOnLeft();
        Map<Integer, List<TestClass2>> onlyOnRight = difference.entriesOnlyOnRight();


    }


}

@Accessors(chain = true)
@Data
class DemoTestClass {

    private List<String> list;

    private String name;

    private Date date;
}


@Data
@Accessors(chain = true)
class TestClass2{

    private Integer id;

    private String name;

    private Integer number;

}
