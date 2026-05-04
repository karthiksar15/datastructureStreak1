class May0426{
public static void main(String[] args)
{
String s1= "abc";
Sting s2 = "lecabee";
May0426 may= new May0426();
System.out.println("check---"+check inclusion(s1,s2));
}
public boolean checkInclusion(String s1,String s2)
{if(s2.length()lts1.length())
{
return false;
}
int l=0;
int[] s1count=new int[128];
int[] s2count=new int[128];
for(int i=0;i‹s1.length;i++)
{
 s1count[s1.charAt(i)]++;
 s2count[s2.charAt(i)]++;
}
for(int r=s1.length;r<s2.length;r++)
{
  if(matches(s1,s2)
  {
 return true;
}
 s2count[s2.charAt(l)]--;
s2count[s2.charAt(r)]++;
}
return false;
}
public boolean matches(int[] s1,int s2)
{
for(int i=0;i<26;i++)
{
 if(s1[i]!=s2[i])
 {
 return false;
}
}
return true;
}
}