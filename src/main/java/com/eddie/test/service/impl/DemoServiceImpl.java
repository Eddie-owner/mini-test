package com.eddie.test.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.eddie.test.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: chenaidi
 * @date: 2020/11/6
 * @description:
 */
@Service
public class DemoServiceImpl implements DemoService {
    private final static String TWO = "a,b,c";
    private final static String THREE = "d,e,f";
    private final static String FOUR = "g,h,i";
    private final static String FIVE = "j,k,l";
    private final static String SIX = "m,n,o";
    private final static String SEVEN = "p,q,r,s";
    private final static String EIGHT = "t,u,v";
    private final static String NINE = "w,x,y,z";
    private static List<String> fix;

    @Override
    public List<String> getWords(List<Integer> arr) {
        List<String> result = new ArrayList<>();
        Collections.sort(arr);
        List<Integer> turn=new ArrayList<>(arr);

        if (turn.size()==1){
            return fix = getList(turn.get(0).toString());
        }
        for (int i=0;i<turn.size();i++){
            if (turn.get(i) == 0 || turn.get(i) == 1){
                continue;
            }
            if (fix==null) {
                fix = getList(turn.get(i).toString());
                continue;
            }
            for (String f: fix) {
                for (String str : getList(turn.get(i).toString())) {
                    StringBuilder sb=new StringBuilder(f);
                    sb.append(str);
                    result.add(sb.toString());
                }
            }
            fix=result;
            if (result.iterator().hasNext() && i!=turn.size()-1){
                result=new ArrayList<>();
            }
        }
        return result;
    }


    /**
     * 匹配
     *
     * @param param
     * @return
     */
    private List<String> getList(String param) {
        String init = null;
        switch (param) {
            case "2":
                init = TWO;
                break;
            case "3":
                init = THREE;
                break;
            case "4":
                init = FOUR;
                break;
            case "5":
                init = FIVE;
                break;
            case "6":
                init = SIX;
                break;
            case "7":
                init = SEVEN;
                break;
            case "8":
                init = EIGHT;
                break;
            case "9":
                init = NINE;
                break;
            default:
                init = null;
        }
        return getPool(init);
    }

    /**
     * 转为集合
     *
     * @param param
     * @return
     */
    private List<String> getPool(String param) {
        List<String> list = new ArrayList<>();
        if (param != null) {
            String[] arr = param.split(",");
            list = Arrays.asList(arr);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> q = new ArrayList<>();
        q.add(0);
        q.add(1);
        q.add(2);
        Collections.sort(q);
        q.remove(0);
        for (Integer i : q) {
            if (i == 0 || i == 1) {
                q.remove(0);
                break;
            }

        }
        System.out.println(JSONObject.toJSONString(q));
    }
}
