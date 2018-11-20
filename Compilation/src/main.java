import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class main {

	public static int o=0;
	public static int cpt=0;
	
	public static void main(String[] args)
	{
		
		
		 JButton j1=new JButton("Charger Un fichier");
		 JButton j2=new JButton("Analyse lexicale");
		  JButton j3=new JButton("Analyse syntaxique");
		  JButton j4=new JButton("Analyse semantique");
		  JPanel pan=new JPanel();
		  JTextArea t1=new JTextArea("fichier");
		pan.setLayout(null);
		
	Border in=BorderFactory.createTitledBorder("Commandes");
		
		
		Border out=BorderFactory.createEmptyBorder(10,10,10,575);
		pan.setBorder(BorderFactory.createCompoundBorder(out, in));
		pan.setBorder(BorderFactory.createCompoundBorder(out, in));
		
		t1.setForeground(Color.BLUE);
		t1.setBackground(new Color(207,207,207));
		t1.setOpaque(true);
		t1.setBounds(250,50,500,600);
	t1.setAlignmentX(0);
		
		pan.add(t1);
		
		j1.setBounds(25,50,150,85);
		j2.setBounds(25,150,150,85);
		j3.setBounds(25,250,150,85);
		j4.setBounds(25,350,150,85);
		
		pan.add(j1);
		pan.add(j2);
		pan.add(j3);
		pan.add(j4);
		
		JFrame fen=new JFrame();
		fen.setLocationRelativeTo(null);
		
		
		
		
		j1.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						t1.setText(readFile("res/ez.txt"));
						System.out.print("le contenu\n"+readFile("res/ez.txt"));
						
						
						
					}
			
				});
		
	
		
		
      fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fen.setContentPane(pan);
      fen.setSize(800,700);
  	fen.setLocationRelativeTo(null);
        fen.setVisible(true);
		
        ////////////////////////////////////////test////////////////////////////////////////////////////////////////////////////////////////////////////////////
		List l=new LinkedList();
		 l.add("Start_Programme");
		 l.add("");
		 l.add("");
		 l.add(""); 
		 l.add("");
		 l.add("");
		 l.add("");
		 l.add("");
		 l.add("");
		 l.add("");
		 
		String str="lol je sais pas mais je reussirai";
			String[] st1=readFile("res/ez.txt").split("\n");
			String[] st2=readFile("res/ez.txt").split("\n");
			String[] st3= {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
			
			Object dic[][]= { 
					{'S','t','a','r','t','_','P','r','o','g','a','m'},
					{'E','l','s','e' },
					{ 'S','t','a','r','t'},
					{ 'F','i','n','i','s','h'},
					{'S','h','o','w','M','e','s' ,':' ,'"','"' ,';',';'},
					{'/','/','.'},
					{'E','n','d','_','P','r','o','g','r','a','m'},
					{'S','t','a','r','t','_','P','r','o','g','a','m'},
					{'S','t','a','r','t','_','P','r','o','g','a','m'},
					{'S','t','a','r','t','_','P','r','o','g','a','m'},
					{'S','t','a','r','t','_','P','r','o','g','a','m'},
					{'S','t','a','r','t','_','P','r','o','g','a','m'},
					
					        };
			
	/////////section reconnaissance identificateur....
			
			
			
			for(int j=0;j<st1.length;j++)
			{
				if(st1[j].indexOf("Number")>=0)
				{
					st2[j]=st2[j]+"-->declaration variable\n";
				}
				
				if(st1[j].indexOf("If")>=0)
				{
					st2[j]=st2[j]+"-->Condition avec AFFECTATION\n";
				}
				
				if(st1[j].indexOf("Affect")>=0)
				{
					st2[j]=st2[j]+"-->affect i dans j\n";
				}
				
				if(st1[j].indexOf("ShowMes")>=0)
				{
					st2[j]=st2[j]+"-->affichage message\n";
				}
				
				if(st1[j].indexOf("ShowMes")>=0)
				{
					st2[j]=st2[j]+"-->affichage valeur\n";
				}
				
				if(st1[j].indexOf("Start_Program")>=0)
				{
					st2[j]=st2[j]+"-->debut du programme\n";
				}
				
				if(st1[j].indexOf("End_Program")>=0)
				{
					st2[j]=st2[j]+"-->fin du programme\n";
				}
				if(st1[j].indexOf("Start")>=0)
				{
					st2[j]=st2[j]+"-->Debut Boucle\n";
				}
				if(st1[j].indexOf("Finish")>=0)
				{
					st2[j]=st2[j]+"-->fin boucle\n";
				}
				if(st1[j].indexOf("//.")>=0)
				{
					st2[j]=st2[j]+"-->commentaire\n";
				}
			}
			
			
			for(int i=0;i<st1.length;i++)
			{ 
				System.out.print("affiche "+i+":"+st1[i]+"\n");
				
			}
			
			//Analyse lexicale*********************************************************************------------------------------>>>>>>>>>>>>>>>>>>>>>>>>
			
			for(int j=0;j<st1.length;j++)
			{
				//test si la ligne de codes contient des variables
				
				if((st1[j].indexOf("Int_Number")>=0) | (st1[j].indexOf("Real_Number")>=0) | (st1[j].indexOf("ShowVal")>=0))
				{
					
					System.out.print("les lignes detecter : "+st1[j]+"\n");
					System.out.print("\n"+j+"\n");
					
					String[] chaineA=st1[j].split(" ");
					
					for(int m=0;m<chaineA.length;m++)
					{ System.out.print("la chaine d analyse avec variable est -> "+chaineA[m]+"\n"); }
					
					String[] chaineB=chaineA[2].split(",");
					
					for(int cpt1=0;cpt1<chaineB.length;cpt1++)
					{ System.out.print("la sous-chaine d analyse avec variable est -> "+chaineB[cpt1]+"\n"); }
					
					System.out.print(chaineA[0]+"\n");
					String der="";
					
					System.out.print("la derniere variable "+chaineB[chaineB.length-1]+"\n");
	               
					/*String[] chaineC=chaineB[chaineB.length-1].split(" ");
					
					for(int cpt1=0;cpt1<chaineC.length;cpt1++)
					{ System.out.print("les valeur final : "+chaineC[cpt1]+"\n"); }	*/
					
					
				
					
					
			   if(chaineA[0].equals("Int_Number"))
			   {
				   System.out.print("entier bien reconnue\n");
				   st3[j]=chaineA[0]+"->Declaration entier bien reconnue\n";
			   }
				
			   else if(chaineA[0].equals("Real_Number"))
			   {
				   System.out.print("réel bien reconnue"); 
				   st3[j]=chaineA[0]+"->Declaration réel bien reconnue\n";
			   }
					
			   else if(chaineA[0].equals("ShowVal"))
			   {
				   System.out.print("affichage bien reconnue");
				   st3[j]=chaineA[0]+"->affichage bien reconnue\n";
			   }
			   
			  /* String test="dentifiant99";
				String res=VerifId(test);
				System.out.print("\nvoila le resultat !!!  "+res+"\n");*/
				
				}
				
				
				
				else if(st1[j].indexOf("Give")>=0 && st1[j].indexOf("If")<=0)
                {
					System.out.print("\nles lignes detecter : "+st1[j]+"\n");
				
					
					String [] chaineC=st1[j].split(" ");
					
					for(int i=0;i<chaineC.length;i++)
					{
						System.out.print("\nles sous chaines : "+chaineC[i]);
					}
					
					System.out.print("\nla chaine de comparaison : "+chaineC[2]);
					//String cmp1=(VerifId(chaineC[3]));
					//String cmp2=(VerifId(chaineC[5]));
					int pos=PostionDebut(chaineC);
					
					System.out.print("\nnombre debut "+pos+"\n");
					
					/*char[] car = chaineC[2].toCharArray();
					for(int i=0;i<car.length;i++) 
					{
						System.out.print("\n carac "+i+" : "+car[i]);
					}
					
					String div1=""+car[0];
					String div2=""+car[1];
					String div3=""+car[2];*/
					int i=0;
					
					   
					if(chaineC[0].equals("If"))
					{
					   System.out.print("\nCondition detecter");
					   st3[j]=st3[j]+chaineC[0]+"->Condition detecter\n";
					   if(chaineC[2].equals("--"))
					   {
						   System.out.print("\nmot reserve\n");
					   }
					   
					   if(chaineC[1].equals("--") || chaineC[3].equals("--"))
					   {
						   System.out.print("\nmot reserve");
						   st3[j]=st3[j]+chaineC[3]+" mot reserver\n";   
					   }
					   


					 
					    
					    if(chaineC[2].contains("<") || chaineC[2].contains(">") || chaineC[2].contains("="))
						  {
							  System.out.print("\noperateur de comparaison detecter");
							  st3[j]=st3[j]+"\n Operateur detecter\n"+chaineC[2]+"\n";
							  String[] chaineD=chaineC[2].split("<");
							  
							  if(chaineD[0].equals(VerifId(chaineD[0])))
							   {
								   System.out.print("\nidentifiant detecter");
								   st3[j]=st3[j]+chaineD[0]+" identifiant detecter \n";
							   }
							  
							   if(chaineD[1].equals(VerifId(chaineD[1])))
							   {
								   System.out.print("\nidentifiant detecter");
								   st3[j]=st3[j]+chaineD[1]+" identifiant detecter\n";
							   }
							 
							   if(chaineC[1].equals("--") || chaineC[3].equals("--"))
							   {
								   System.out.print("\nmot reserve");
								   st3[j]=st3[j]+chaineC[1]+" mot reserver \n";
							   }
							   	   
							   if(chaineC[4].equals("Give"))
							   {
								   System.out.print("\n ->affectation valeur");
								   st3[j]=st3[j]+chaineC[4]+"-> affectation \n";
							   }
							   
							   if(chaineC[6].equals(" :"))
							   {
								   System.out.print("\n mot reserve");
								   st3[j]=st3[j]+chaineC[6]+"\n mot reserve \n";
							   }
							   
							   if(NumberType(chaineC[6])<0)
							   {
								   System.out.print("\nvaleur entiere");
								   st3[j]=st3[j]+chaineC[6]+" mots reserve\n";
							   }
							   
							   if(NumberType(chaineC[6])<0)
							   {
								   System.out.print("\nmot reserve");
								   st3[j]=st3[j]+chaineC[7]+":valeur entier\n";
							   }
							   
							   if(chaineC[8].equals(";;"))
							   {
								   System.out.print("\nmot reserve");
								   st3[j]=st3[j]+chaineC[8]+"->mots reserver\n";
							   }
							   
							   
							   
							  else
							  {
								  System.out.print("\nerreur");
								  st3[j]=st3[j]+chaineD[0]+" erreur\n";
							  }
							}
					    
					    
					
					    
					    
					    
					   else
					   {
						   System.out.print("\nErreur");
						   st3[j]=st3[j]+chaineC[0]+" erreur\n";
					   }
				  
				
					    
					}
					
					
			
					}
				
				else if(st1[j].indexOf("Give")>=0)
                {
					String [] chaineC=st1[j].split(" ");
					System.out.print("\ffectation valeur\n");  
					st3[j]=st3[j]+chaineC[0]+"->Affectation";
					
					if(chaineC[0].equals(" Give"))
					{
				    	System.out.print("affectation valeur\n");
				    	st3[j]=st3[j]+chaineC[0]+"->Affectation";
				    	 st3[j]=st3[j]+chaineC[1]+"\n identifiant detecter";
				 
				    
					}
					
					else if(chaineC[1].equals(VerifId(chaineC[1])))
					   {
						   System.out.print("identifiant detecter\n");
						   st3[j]=st3[j]+chaineC[1]+" identifiant detecter\n";
					   }
					
					if(chaineC[2].equals(":"))
					{
				    	System.out.print("mot reserve");	
				    	 st3[j]=st3[j]+chaineC[2]+" mot reserver\n";
				 
					}
					
					 if(NumberType(chaineC[3])<0)
					   {
						   System.out.print("\nvaleur entiere");
						   st3[j]=st3[j]+chaineC[3]+" valeur entiere\n";
					   }
					 else if(NumberType(chaineC[3])>0)
					   {
						   System.out.print("\nvaleur reel");
						   st3[j]=st3[j]+chaineC[3]+" valeur reel\n";
					   }
					
					
					
                }
				
				else if(st1[j].indexOf("Affect")>=0)
                {
					System.out.print("\nles lignes detecter : "+st1[j]+"\n");
					System.out.print("\nAffectation variable a variable");
					String[] chaineE=st1[j].split(" ");
					
					 st3[j]=st3[j]+chaineE[0]+"\nAffect-> Affectation d une variable a variable\n";
				    
					if(chaineE[0].equals("Affect")) 
					{
						System.out.print("\nAffectation variable a variable");
					}
				    	
					
					if(chaineE[1].equals(VerifId(chaineE[1])))
					{
						System.out.print("\nidentifiant detecer");
						 st3[j]=st3[j]+chaineE[1]+" identifiant detecter\n";
					}
					
					
					
				 if(chaineE[3].equals(VerifId(chaineE[1])))
					{
						System.out.print("\nidentifiant detecer");
						 st3[j]=st3[j]+chaineE[2]+" identifiant detecter\n\n";
					}
					
					else
					{
						st3[j]=st3[j]+" erreur\n";
					}
					
						System.out.print("\n mot reserve");
					
				}
				 
			
	if (st1[j].indexOf("Start_Program")>=0 || st1[j].indexOf("End")>=0 || st1[j].indexOf("Start")>=0 || st1[j].indexOf("Start_Program")>=0 ||st1[j].indexOf("End_Program")>=0 || st1[j].indexOf("Finish")>=0 || st1[j].indexOf("Mes")>=0)
		{
		                System.out.print("\nles lignes detecter : "+st1[j]+"\n");	
		                
		                if(st1[j].equals("Start_Program"))
		                {
		                	System.out.print("\nDebut du programme");
		                	st3[j]=st3[j]+st1[j]+" debut du programme\n";
		                }
		                
		                if(st1[j].equals("End_Program"))
		                {
		                	System.out.print("\nfin du programme");
		                	st3[j]=st3[j]+st1[j]+" fin du programme\n";
		                }
		                if(st1[j].equals("Start"))
		                {
		                 	System.out.print("\nDebut boucle");
		                 	st3[j]=st3[j]+st1[j]+" debut de boucle \n";		                
		                }
		              
		                if(st1[j].contains("Mes"))
		                {
		                	st3[j]=st3[j]+st1[j]+" message detecter\n";
		                	System.out.print("Message");
		                }
		               
		                
		}
	
	if(st1[j].indexOf("//.")>=0)
	{
		String [] s=st1[j].split(" ");
		
		
		
		if(s[0].equals("//."))
		{
			System.out.print("\ncommentaire detectes");
			st3[j]=st3[j]+s[0]+"->> commentaires detectes\n";
		}
	}
				//sinon on transforme les String en Char pour les analyser integralement
				
				/*else {
				
					System.out.print("\n"+j+"\n");
					char[] carac = st1[j].toCharArray();
				
				int k=0;
				while(k < st1[j].length())
				{
				    if(dic[j][k].equals(carac[k]))
				    {
				    	k++;
				    	System.out.print("analyse reussi\n");
				    }
				    
				    else
				    {
				    	k=st1[j].length();
				      System.out.print("probleme detecter\n");
				    }
				}
				
			}*/
				//System.out.print(j);
			}
			
			/*var chaine = « Hello World ! » ;
			var position = chaine.indexOf("World"); //La variable position reçoit la valeur 6, la chaîne contient cette sous-chaîne.
			position = chaine.indexOf("world"); //La variable position reçoit la valeur -1, la chaîne ne contient pas cette sous-chaîne.*/
			
			
	
			

		/////////////////////////////////////fin test/////////////////////////////////**************************************************************************
		  
			j2.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
	               String resultat="";
					for(int i=0;i<st3.length;i++)
	               {
	            	   System.out.print("voice la chaine "+st3[i]+"\n");
	            	   resultat=resultat+st3[i];
	               }
					System.out.print("\nvoila-->"+st1[2]);
					
					st3[st3.length-1]=st3[st3.length-1]+st1[2];
					st3[st3.length-1]=st3[st3.length-1]+st1[5];
					
					t1.setText(resultat);
					
				}
		
			});
			
			j3.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0) 
				{
	         
					
				  if( analyse(st1).equals("reussi"))
				  {
					  t1.setText(analyse(st1));
					  
					  j4.addActionListener(new ActionListener()
							  {

								@Override
								public void actionPerformed(ActionEvent arg0) {
								
									   String resultat="";
										for(int i=0;i<st1.length;i++)
						               {
						            	   
						            	   resultat=resultat+st2[i]+"\n";
						               }
										t1.setText(resultat);
								}
						  
							  });}
				  
				  else
				  {
					  t1.setText("Chaine non acceptes");
					  j4.setText("Impossible");
				  }
					
				}
		
			});
		  
	}
	
	public static String readFile( String file )
    {
        // LIS LE FICHIER
        String lines = "";
        String line;
        try
        {
            // CREE LE FLUX
            BufferedReader reader = new BufferedReader( new FileReader(file) );
             
            // LIS LIGNE A LIGNE
            while( (line = reader.readLine()) != null )
                lines += line+"\n";
        }
        catch( Exception e )
        {
            lines = "Une erreur s'est produite durant la lecture du flux : "+e.getMessage();
        }  
         
        return lines;
    }
	//fonction verification identificateur code ASSCII
	public static String VerifId(String res)
	{
		
		char[] carac = res.toCharArray();
		
		String str="";
		
		for(int i=0;i<carac.length;)
		{
		
			if(i==0)
			{
			    if((carac[i]>65 && carac[i]<91) || (carac[i]>96 && carac[i]<123))
			    {
			    	str=str+carac[i];
			    	i++;
			    	
			    }
			    
			    else
	    		{
			    	str="erreur identifiant";
			    	i=carac.length;	
	    		}
			}
			
			else if(i>0)
			{
				 if((carac[i]>65 && carac[i]<91) || (carac[i]>96 && carac[i]<123) || (carac[i]>47 && carac[i]<58))
				 {
					 str=str+carac[i];
					 i++;
					 
				 }
				 else
		    		{
					 str="erreur identifiant";
					 i=carac.length;
		    		} 
			}
			
		}
		
		return str;
		
	}
	
	public static int NumberType(String str)
	{
		int r=0;
		
		String[] is=str.split(".");
		
		if(is.length==2)
		{
			r=1;
		}
		
		else if(is.length<2)
			{r=-1;}
		
		return r;
		
	}
	
	public static int PostionDebut(String[] str)
	{
		int r=0;
		
    while(o<str.length)
    {
    	if(str[o].equals(" "))
    	o++;
    	
    	else
    		cpt=o;
    	o=str.length;
    
    	    
    }
		r=cpt-1;
    return r;
		
	}
	
	public static String analyse(String[] str)
	{
		String res="";
		
		if(str[0].equals("Start_Program") &&  str[str.length-1].equals("End_Program")) 
				{
			      
			    	   System.out.print("pas de repetitions");
			    	   res="reussi";
			      
			       
			     
				}
		
		
		return res;
		
	}


	public static boolean Repet(String[] str)
	{
		int cpt=0;
		for(int i=0;i<str.length;i++)
		{
			for(int j=0;j<str.length;j++)
			{
				if(str[i].equals(j)) {
					cpt++;
				}
			}
			
			if (cpt>1)
			{
				return false;
			}
			
			else
			{
				return true;
			}
		}
		
		return false;
		
	}
}
