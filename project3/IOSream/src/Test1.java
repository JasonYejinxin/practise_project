import org.junit.Test;

import java.io.*;
import java.util.*;

//获取文本上每个字符出现的次数
//提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据
//写入文件
public class Test1 {

    @Test
    public void test() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("Assignment2.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Assignment3.txt")));

        Map<Character,Integer> map = new HashMap();

        int len;
//        int num = 1;
        char []cbf = new char[1024];
        while((len = br.read(cbf)) != -1){
            for(int i = 0; i < len; i++){
                if(map.containsKey(cbf[i])){
                    map.put(cbf[i],map.get(cbf[i]) + 1);
                }
                else
                map.put(cbf[i],1);
            }
        }


        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        Object obj = null;
        while(iterator.hasNext()){
            obj = iterator.next();
        Map.Entry entry = (Map.Entry)obj;
        bw.write(entry.getKey() + ":" + entry.getValue() + "\n");
        System.out.println(entry.getKey() + ":" + entry.getValue());
    }
        br.close();
        bw.close();
    }
}
