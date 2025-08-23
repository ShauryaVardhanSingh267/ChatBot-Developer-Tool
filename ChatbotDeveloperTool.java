import java.util.*;
class ChatbotDeveloperTool
{
    static Scanner ob = new Scanner(System.in);
    static int m;
    static String a[][];
    ChatbotDeveloperTool(int mm)
    {
        m=mm;
        a=new String[m][2];
    }
    void accept() 
    {
        for (int i = 0; i < m; i++) 
        {
            System.out.println("Enter question " + (i + 1) + ": ");
            a[i][0] = ob.nextLine();
            System.out.println("Enter answer " + (i + 1) + ": ");
            a[i][1] = ob.nextLine();
        }
    }
    static String code()
    {
        String s = "import java.util.*;\n" +
                    "class ChatBot\n" +
                    "{\n" +
                    "    static Scanner ob = new Scanner(System.in);\n" +
                    "    int m="+m+";\n" +
                    "    String arr[][];\n" +
                    "    int array[];\n" +
                    "    static String inp;\n" +
                    "    ChatBot()\n" +
                    "    {\n" +
                    "        arr=new String[m][2];\n" +
                    "        array=new int[m];\n" +
                    "        inp=\"\";\n" +
                    "    }\n" +
                    "    void accept()\n" +
                    "    {\n";
                            for(int i=0;i<m;i++)
                            {
                                s+= "arr["+(i)+"][0] = "+"\""+a[i][0]+"\";\n";
                                s+= "arr["+(i)+"][1] = "+"\""+a[i][1]+"\";\n";
                            }
               s+=  "    }\n" +
                    "    ArrayList<String> keywords(String word)\n" +
                    "    {\n" +
                    "        ArrayList<String> key = new ArrayList<String>();\n" +
                    "        StringTokenizer st = new StringTokenizer(word);\n" +
                    "        int n=st.countTokens();\n" +
                    "        for(int i=1;i<=n;i++)\n" +
                    "        {\n" +
                    "            String a = st.nextToken();\n" +
                    "            if(a.length()>3)\n" +
                    "            key.add(a);\n" +
                    "        }\n" +
                    "        return key;\n" +
                    "    }\n" +
                    "    void matches()\n" +
                    "    {\n" +
                    "        int count=0;\n" +
                    "        for(int i=0;i<m;i++)\n" +
                    "        {\n" +
                    "            count=0;\n" +
                    "            String wrd=arr[i][0];\n" +
                    "            ArrayList <String> x=keywords(wrd);\n" +
                    "            ArrayList <String> y=keywords(inp);\n" +
                    "            for(int k=0;k<x.size();k++)\n" +
                    "            {\n" +
                    "                String word1=x.get(k);\n" +
                    "                for(int l=0;l<y.size();l++)\n" +
                    "                {\n" +
                    "                   String word2=y.get(l);\n" +
                    "                   if(word1.equalsIgnoreCase(word2))\n" +
                    "                   {\n" +
                    "                       count++;\n" +
                    "                   }\n" +
                    "                }\n" +
                    "            }\n" +
                    "            array[i]=count;\n" +
                    "        }\n" +
                    "        int max=0;\n" +
                    "        for(int j=1;j<m;j++)\n" +
                    "        {\n" +
                    "            if(array[j]>array[max])\n" +
                    "            max=j;\n" +
                    "        }\n" +
                    "        int smax=0;\n" +
                    "        for(int j=1;j<m;j++)\n" +
                    "        {\n" +
                    "            if(array[j]>array[smax]&&array[j]<array[max])\n" +
                    "            smax=j;\n" +
                    "        }\n" +
                    "        if(!inp.equalsIgnoreCase(\"STOP\"))\n" +
                    "        {\n" +
                    "           if((array[max]-array[smax])<=1)\n" +
                    "           System.out.println(\"Chat Bot : The question is a bit unclear but here is the answer \\n\\t\\t\"+arr[max][1]+\"\\n\\t\\t hope this is what you were looking for\");\n" +
                    "           else if(array[max]>1)\n" +
                    "           System.out.println(\"Chat Bot : \"+arr[max][1]);\n" +
                    "           else\n" +
                    "           System.out.println(\"Chat Bot : Sorry I don\\'t know the answer to this question \\n\\t\\t try rephrasing your question \");\n" +
                    "        }\n" +
                    "    }\n" +
                    "    public static void main(String args[])\n" +
                    "    {\n" +
                    "        ChatBot obj = new ChatBot();\n" +
                    "        System.out.println(\"Chat Bot : Tell me whatever your querry is and i will try to answer it\\nRemember to enter STOP whenever you want to end the conversation\");\n" +
                    "        do\n" +
                    "        {\n" +
                    "            System.out.print(\"You : \");\n" +
                    "            inp =ob.nextLine();\n" +
                    "            System.out.println();\n" +
                    "            obj.accept();\n" +
                    "            obj.matches(); \n" +
                    "        }\n" +
                    "        while(!inp.equalsIgnoreCase(\"STOP\"));\n" +
                    "        System.out.println(\"Chat Bot : Thank You , I hope that i was able to help \");\n" +
                    "    }\n" +
                    "}";
        return s;
    }
    public static void main(String args[])
    {
        System.out.println("Enter the number of questions");
        int mm=ob.nextInt();
        ob.nextLine();
        ChatbotDeveloperTool obj = new ChatbotDeveloperTool(mm);
        obj.accept();
        String chat = code();
        System.out.println("The code for your chatbot is :\n\n\n");
        System.out.println(chat);
    }
}