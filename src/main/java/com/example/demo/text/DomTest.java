package com.example.demo.text;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomTest {

    /**
     * dom 解析 book.xml
     */

    public static void domTest() {


        try {
            //创建DocumentBuilder工厂
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //创建一个DocumentBuilder的对象
            DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
            //通过DocumentBuilder对象的parse方法家在book.xml 文件到到当前项目下
            Document document = db.parse("/Users/lixianglong/Downloads/springboot/src/main/resources/book.xml");
            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("book");
            //通过NodeList的gelength()方法获取booklist的长度
            System.out.println("一共有" + bookList.getLength() + "本书\n");

            //遍历每一个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("========开始遍历" + (i + 1) + "本书\n");
                //获取bookList的每一个节点
                Node book = bookList.item(i);
                //获取book节点的虽有所有属性的集合
                NamedNodeMap attr = book.getAttributes();
                System.out.println("第" + (i + 1) + "本书共有" + attr.getLength() + "个属性");

                for (int j = 0; j < attr.getLength(); j++) {
                    //通过item获取book节点的每一个属性
                    Node attrs = attr.item(j);
                    //获取属性名
                    System.out.println("属性名" + attrs.getNodeName());
                    //获取属性值
                    System.out.println("属性值" + attrs.getNodeValue());

                }

                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历childNodes获取每个节点的节点名和节点值
                System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点");

                for (int k = 0; k < childNodes.getLength(); k++) {
                    //区分出text类型的node以及elment类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        //获取了element节点的节点名
                        System.out.println("第" + (k + 1) + "个节点的节点名" + childNodes.item(k).getNodeName());
                        //获取elment节点的节点值
                        System.out.println("--节点值为：" + childNodes.item(k).getFirstChild().getNodeValue());


                    }
                }
                System.out.println("遍历结束 " + "共有" + (i + 1) + "本书");


            }


        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public static void main(String[] args) {
        domTest();
    }
}
