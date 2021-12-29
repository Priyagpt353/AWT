import java.awt.*;
import java.awt.event.*;
class Calculator implements ActionListener
{
    Frame fr;
    Button b[]=new Button[19];
    String str[];
    int x=100,y=100,z=1;
    String op;
    TextField t;
    double p,q,r;
    public Calculator()
    {
        this.str = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/", ".", "=", "Clr", "Back", "On"};
        this.x = 100;
        fr=new Frame("My Calculator");
        fr.setSize(430,430);
        fr.setLayout(null);
        t = new TextField();
        t.setBounds(100, 60, 230, 30);
        for(int i=0;i<b.length;i++)
        {
            b[i] = new Button(str[i]);
            b[i].setBounds(x,y,50,30);
            b[i].setFont(new Font("georgia",Font.BOLD|Font.ITALIC,15));
            fr.add(b[i]);
            b[i].setEnabled(false);
            b[i].addActionListener(this);
            if(z<4)
            {
                x=x+60;
                z++;
            }
            else
            {
                y=y+40;
                x=100;
                z=1;
            }
        }
        b[18].setSize(110, 30);
        b[18].setEnabled(true);
        fr.add(t); 
        fr.setVisible(true);
        fr.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                fr.dispose();
            }
        });
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
        if(!(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("=")||s.equals("Clr")||s.equals("Back")||s.equals("Off")||s.equals("On")))
        {
            if((t.getText().indexOf(".")==-1) && s.equals("."))
            {
                 t.setText(t.getText()+".");
            }
            else
            {
                if(!s.equals("."))
                {
                     t.setText(t.getText()+s);
                }
            }
        }
        if(s.equals("On"))
        {
            for(int i=0;i<b.length-1;i++)
            {
                b[i].setEnabled(true);
            }
            b[18].setLabel("Off");
        }
        else if(s.equals("Off"))
        {
            for(int i=0;i<b.length-1;i++)
            {
                b[i].setEnabled(false);
            }
             t.setText("");
            b[18].setLabel("On");
        }
        if(s.equals("Clr"))
        {
            t.setText("");
            p=0;
            q=0;
            r=0;
        }
         if(s.equals("Back"))
	    {
		String si = t.getText();
		si = si.substring(0,si.length()-1);
		t.setText(si);	
            }
        if(s.equals("+"))
        {
            p=Double.parseDouble(t.getText());
            t.setText("");
            op="+";
        }
        if(s.equals("-"))
        {
            p=Double.parseDouble(t.getText());
            t.setText("");
            op="-";
        }
        if(s.equals("/"))
        {
            p=Double.parseDouble(t.getText());
            t.setText("");
            op="/";
        }
        if(s.equals("*"))
        {
            p=Double.parseDouble(t.getText());
            t.setText("");
            op="*";
        }
        if(s.equals("="))
        {
            if(op.equals("+"))
            {
                q=Double.parseDouble(t.getText());
                r = p+q;
                t.setText(""+r);
            }
            if(op.equals("-"))
            {
                q=Double.parseDouble(t.getText());
                r = p-q;
                t.setText(""+r);
            }
            if(op.equals("*"))
            {
                q=Double.parseDouble(t.getText());
                r = p*q;
                t.setText(""+r);
            }
            if(op.equals("/"))
            {
                q=Double.parseDouble(t.getText());
                r = p/q;
                t.setText(""+r);
            }
        }
    }
    public static void main(String a[])
    {
        new Calculator();
    }
}