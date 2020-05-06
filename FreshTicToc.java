import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 class TicTocFrame implements ActionListener
{
	JFrame fr;
	JPanel pn;
	JButton bt[][];
	JTextField tp1,tp2,tpw1,tpw2,tpl1,tpl2,tps1,tps2;
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Dimension dim=toolkit.getScreenSize();
	int h=(int)dim.getHeight();
	int w=(int)dim.getWidth();
	int alternate = 0,game=0;
	char player1,player2;
	JButton bplay,breset,bexit;
	int chk =0 ;
	int z=0;
	int Arr[][]=new int[][]{{0,0,0},{0,0,0},{0,0,0}};
	int w1=0,l1=0,w2=0,l2=0,score1=0,score2=0; 
	int counter = 0 ;
	int win=0 ;
	
	TicTocFrame()
	{
	
		fr=new JFrame("Tic Toc");
		bt=new JButton[3][3];
		pn=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				g.drawImage(new ImageIcon("background.png").getImage(),0,0,w,h,null );
			}
		};
		pn.setLayout(null);
		pn.setBounds(0,0,w,h);
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				bt[i][j]=new JButton();
				bt[i][j].setText("");
				bt[i][j].setBorder(BorderFactory.createLineBorder(Color.black,2));
				bt[i][j].setBackground(Color.white);
		        bt[i][j].setForeground(Color.BLACK);
		        bt[i][j].setFont(new Font("Times New Roman",Font.BOLD,30));
		        pn.add(bt[i][j]);
			}
		}
		
		bt[0][0].setBounds(310,430,140,140);
		bt[0][1].setBounds(450,430,140,140);
		bt[0][2].setBounds(590,430,140,140);
		
		bt[1][0].setBounds(310,570,140,140);
		bt[1][1].setBounds(450,570,140,140);
		bt[1][2].setBounds(590,570,140,140);
		
		bt[2][0].setBounds(310,710,140,140);
		bt[2][1].setBounds(450,710,140,140);
		bt[2][2].setBounds(590,710,140,140);
		
		
		bplay=new JButton("Play");
		breset=new JButton("Reset");
		bexit=new JButton("Exit");
		
		bplay.setBounds(950,300,150,60);
		breset.setBounds(950,400,150,60);
		bexit.setBounds(950,500,150,60);
		
		
		 bplay.setForeground(Color.BLACK);
	     bplay.setFont(new Font("Times New Roman",Font.BOLD,30));
	     bplay.setBorder(BorderFactory.createLineBorder(Color.black,2));
	     bplay.setBackground(new Color(33,33,233,175));
	     
	     breset.setForeground(Color.BLACK);
	     breset.setFont(new Font("Times New Roman",Font.BOLD,30));
	     breset.setBorder(BorderFactory.createLineBorder(Color.black,2));
	     breset.setBackground(new Color(33,33,233,175));
	     
	     bexit.setForeground(Color.BLACK);
	     bexit.setFont(new Font("Times New Roman",Font.BOLD,30));
	     bexit.setBorder(BorderFactory.createLineBorder(Color.black,2));
	     bexit.setBackground(new Color(33,33,233,175));
	        
	        
	        
		
		

		//TextField
		tp1=new JTextField();
		tp2=new JTextField();
		tpw1=new JTextField();
		tpw2=new JTextField();
		tpl1=new JTextField();
		tpl2=new JTextField();
		tps1=new JTextField();
		tps2=new JTextField();
		
		tp1.setBounds(1240,500,250,50);
		tp2.setBounds(1510,500,250,50);
		
		tpw1.setBounds(1300,630,150,50);
		tpw2.setBounds(1575,630,150,50);
		
		tpl1.setBounds(1300,750,150,50);
		tpl2.setBounds(1575,750,150,50);
		
		tps1.setBounds(1300,880,150,50);
		tps2.setBounds(1575,880,150,50);
		
		
		fr.setLayout(null);
		fr.add(pn);
		
		pn.add(bplay);
		pn.add(breset);
		pn.add(bexit);
		
		pn.add(tp1);
		pn.add(tp2);
		pn.add(tpw1);
		pn.add(tpw2);
		pn.add(tpl1);
		pn.add(tpl2);
		pn.add(tps1);
		pn.add(tps2);
		
		fr.setSize(w,h);
		fr.setVisible(true);
		

        for(int i = 0; i < 3; i++)
        {
        	for(int j = 0; j < 3; j++)
            {
	            bt[i][j].addActionListener(this);         
	            bt[i][j].setEnabled(false);
            }
        }
        
        
        tp1.setForeground(Color.BLACK);
        tp1.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tp2.setForeground(Color.BLACK);
        tp2.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tpw2.setForeground(Color.BLACK);
        tpw2.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        
        tpw1.setForeground(Color.BLACK);
        tpw1.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tpw2.setForeground(Color.BLACK);
        tpw2.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tpl1.setForeground(Color.BLACK);
        tpl1.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tpl2.setForeground(Color.BLACK);
        tpl2.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tps1.setForeground(Color.BLACK);
        tps1.setFont(new Font("Times New Roman",Font.BOLD,30));
        
        tps2.setForeground(Color.BLACK);
        tps2.setFont(new Font("Times New Roman",Font.BOLD,30));
        
       
        
        bplay.addActionListener(this);
        breset.addActionListener(this);
        bexit.addActionListener(this);
        
        tpw1.setEnabled(false);
        tpw2.setEnabled(false);
        tpl1.setEnabled(false);
        tpl2.setEnabled(false);
        tps1.setEnabled(false);
        tps2.setEnabled(false);
        
        tpw1.setText("0");
        tpw2.setText("0");
        tpl1.setText("0");
        tpl2.setText("0");
        tps1.setText("0");
        tps2.setText("0");
        
        if(game%2==0)
        {
        	player1='x';
        	player2='0';
        }
        else
        {
        	player1='0';
        	player2='x';
        }
	}
	
	public void resetButtons()
	{
		 tp1.setText("");
		 tp2.setText("");
		 tpw1.setText("0");
		 tpw2.setText("0");
		 tpl1.setText("0");
		 tpl2.setText("0");
		 tps1.setText("0");
		 tps2.setText("0");
		 
		 
		 counter = 0 ;
		 w1=0;
		 l1=0;
		 w2=0;
		 l2=0;
		 score1=0;
		 score2=0;
		 
		 
	     for(int i = 0; i <3; i++)
	     {
	    	 for(int j = 0; j<3; j++)
		     {
	          bt[i][j].setText("");
		     }
	     }
	     for(int i = 0; i <3; i++)
	     {
	    	 for(int j = 0; j<3; j++)
		     {
	          Arr[i][j] = 0;
		     }
	     }
	}
	
	//private class buttonListener implements ActionListener
	  //  {
	       
	        public void actionPerformed(ActionEvent ae) 
	        {
	        	
	        	if(ae.getSource()==bplay)
	        	{
	        		if((tp1.getText().equals(""))||(tp2.getText().equals("")))
	        		{
	        			JOptionPane.showMessageDialog(fr,"Welcome to TIC TOC TOE\n Kindly Enter your names");
	        		}
	        		
	        	
		        	else
		        	{
		        		  for(int i = 0; i < 3; i++)
		        		     {
		        			  	play();
		        		    	 for(int j = 0; j< 3; j++)
		        			     {       
		        		    		 bt[i][j].setEnabled(true);
		        			     }
		        	        }
		        		
		        	}
	        	}
	        	
	        	if(ae.getSource()==breset)
	        	{
	        		resetButtons();
	        	}
	        	
	        	if(ae.getSource()==bexit)
	        	{
	        		JOptionPane.showConfirmDialog(null, "Do you want to exit");
	        	}
	        	
	            
	            //JButton buttonClicked = (JButton)ae.getSource(); //get the particular button that was clicked
	         

  	    		//win check comndition
	        	
	            for(int i = 0; i < 3; i++)
	   	     	{
		   	    	 for(int j = 0; j< 3; j++)
		   		     {
		            	if((ae.getSource()==bt[i][j])&& (z==0) )
		            	{
		            		
				                bt[i][j].setText("X");
				                Arr[i][j] = 1;
				                ++counter;
				                win =checkWin(Arr,i,j);
				                
				                z=1;
				         }
		            	else if((ae.getSource()==bt[i][j])&& (z==1)) 
		            	{
		            		
				                bt[i][j].setText("0");
				                z=0;
				                Arr[i][j] = -1;
				                ++counter;
				                win = checkWin(Arr,i,j);
				         }    
		            	
		            	
		 		   	    
		   		     }
	   	     	}
	            if(win==1)
	            {
	            	JOptionPane.showMessageDialog(fr, "player1 won");
	            	Score(1);
	            	
	            	win = 0;
	            	
	            }
	            else if(win==-1)
	            {
	            	
	            	JOptionPane.showMessageDialog(fr, "player2 won");
	            	Score(2);
	            	win = 0 ;
	   	     	}
	            else if(counter == 9)
	            {
	            	JOptionPane.showMessageDialog(fr, "Match Draw");
	            	counter = 0;
	            	
	            }
	        }
	            
	        
	        //Starting condition
	        
	        public void play()
	        {
	        	 for(int i = 0; i <3; i++)
	    	     {
	    	    	 for(int j = 0; j<3; j++)
	    		     {
	    	          bt[i][j].setText("");
	    		     }
	    	     }
	        	 for(int i = 0; i <3; i++)
	    	     {
	    	    	 for(int j = 0; j<3; j++)
	    		     {
	    	          Arr[i][j] = 0;
	    		     }
	    	     }
	        	 counter = 0;
	        	 
	        }
	        
	        public int checkWin(int arr[][],int i,int j)
	            {
	            	int s1=0,s2=0,s3=0,s4=0;
	        		for(int k = 0;k<3;k++)
	        		{
	        			s1 = s1+arr[k][j];
	        		}
	        		
	        		for(int k = 0;k<3;k++)
	        		{
	        			s2 = s2+arr[i][k];
	        		}
	        		if(i==j)
	        		{
	        			for(int k = 0;k<3;k++)
	        			{
	        				s3 = s3+arr[k][k];
	        			}
	        		}
	        		if(i+j == 2)
	        		{
	        			for(int k=0; k<3; k++)
	        			{
	        				s4 = s4+arr[k][2-k];
	        			}
	        		}
	        		
	        		if((s1 == 3) || (s2 == 3) || (s3 ==3) || (s4 ==3))
	        		{
	        			return 1;
	        		}
	        		else if((s1 == -3) || (s2 == -3) || (s3 == -3) || (s4 == -3))
	        		{
	        			return -1;
	        		}
	        		else
	        		{
	        			return 0;
	        		}
	            }
	            
	        
	        
	        void Score(int scnt)
	        {
	        	if(scnt ==1)
	        	{
	        		tpw1.setText(++w1+"");
	        		tpl2.setText(++l2+"'");
	        		score1 = 4*w1-l1 ;
	        		score2 = 4*w2-l2 ;
	        		tps1.setText(score1+"");
	        		tps2.setText(score2+"");
	        	}

	        	else if(scnt ==2)
	        	{
	        		tpw2.setText(++w2+"");
	        		tpl1.setText(++l1+"'");
	        		score2 = 4*w2-l2 ;
	        		score1 = 4*w1-l1 ;
	        		tps2.setText(score2+"");
	        		tps1.setText(score1+"");
	        	}
	        }
	          
}
public class FreshTicToc 
{
	public static void main(String[] args)
	{
		new TicTocFrame();
	}

}
