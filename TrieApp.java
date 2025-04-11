import java.util.*;
public class TrieApp{
    public static void main(String[]a){
        Scanner sc=new Scanner(System.in);
        Trie r=new Trie();
        while(true){
            System.out.println("1 Insert \n 2 Search \n 3 All Words \n 4 Prefix Words \n 5 Count By Word 0 \nExit");
            int n=sc.nextInt();
            if(n==0)break;
            switch(n){
                case 1:String s1=sc.next();insert(r,s1);break;
                case 2:String s2=sc.next();System.out.println(search(r,s2));break;
                case 3:List<String>l1=new ArrayList<>();getAll(r,l1,"");System.out.println(l1);break;
                case 4:String pf=sc.next();List<String>l2=new ArrayList<>();getPrefix(r,pf,l2);System.out.println(l2);break;
                case 5:String s3=sc.next();System.out.println(count(r,s3));break;
            }
        }
    }
    static void insert(Trie r,String s){
        Trie t=r;
        for(char c:s.toCharArray()){
            int i=c-'a';
            if(t.ch[i]==null)t.ch[i]=new Trie();
            t=t.ch[i];
            t.wc++;
        }
        t.end=true;
    }
    static boolean search(Trie r,String s){
        Trie t=r;
        for(char c:s.toCharArray()){
            int i=c-'a';
            if(t.ch[i]==null)return false;
            t=t.ch[i];
        }
        return t.end;
    }
    static void getAll(Trie r,List<String>l,String s){
        if(r.end)l.add(s);
        for(int i=0;i<26;i++){
            if(r.ch[i]!=null)getAll(r.ch[i],l,s+(char)(i+'a'));
        }
    }
    static void getPrefix(Trie r,String pf,List<String>l){
        Trie t=r;
        for(char c:pf.toCharArray()){
            int i=c-'a';
            if(t.ch[i]==null)return;
            t=t.ch[i];
        }
        getAll(t,l,pf);
    }
    static int count(Trie r,String s){
        Trie t=r;
        for(char c:s.toCharArray()){
            int i=c-'a';
            if(t.ch[i]==null)return 0;
            t=t.ch[i];
        }
        return t.wc;
    }
}
class Trie{
    Trie[]ch;
    int wc;
    boolean end;
    Trie(){
        ch=new Trie[26];
        wc=0;
        end=false;
    }
}
