import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViciousTower {
    JPanel helthPanel, arenaPanel, vt, exp, character, attack, defence, stAttack, stDefence, boss1, boss2, boss3, boss4, tower;
    JProgressBar healthBar;
    JLabel expCounter, perSec, attackCounter, defenceCounter;
    int expNumber, attacks, defences, hp;
    JFrame window;
    Font font1;
    Font font2;
    Font font3;
    Font font4;
    Font font5;
    ExpHandler expHandler = new ExpHandler();
    AttackHandler attackHandler = new AttackHandler();
    DefenceHandler defenceHandler = new DefenceHandler();
    DamageHnadler1 damageHnadler1 = new DamageHnadler1();
    DamageHnadler2 damageHnadler2 = new DamageHnadler2();
    DamageHnadler3 damageHnadler3 = new DamageHnadler3();
    DamageHnadler4 damageHnadler4 = new DamageHnadler4();
    Boss boss11;
    Boss boss22;
    Boss boss33;
    Boss boss44;
//constdonedasdas
    public ViciousTower() {
        boss11 = new Boss("Remiko", 20, 20);
        boss22 = new Boss("Ranzero", 100, 40);
        boss33 = new Boss("Miroku", 150, 50);
        boss44 = new Boss("Judar", 200, 200);

        expNumber = 0;
        attacks = 1;
        defences = 1;
        CreatFont();
        creatUI();


    }

    public void CreatFont() {
        font1 = new Font("Comic Sans MS", Font.PLAIN, 20);
        font2 = new Font("Comic Sans MS", Font.PLAIN, 20);
        font3 = new Font("Comic Sans MS", Font.PLAIN, 35);
        font4 = new Font("Comic Sans MS", Font.PLAIN, 15);
        font5 = new Font("Comic Sans MS", Font.PLAIN, 15);
    }

    public void creatUI() {

        window = new JFrame("Vicious Tower");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setLayout(null);

        arenaPanel = new JPanel();
        arenaPanel.setBounds(80, 400, 250, 140);
        arenaPanel.setBackground(Color.darkGray);
        window.add(arenaPanel);

        vt = new JPanel();
        vt.setBounds(240, 10, 250, 50);
        vt.setBackground(Color.darkGray);

        JLabel vtLabel = new JLabel("Vicious Tower");
        vtLabel.setForeground(Color.white);
        vtLabel.setFont(font3);
        vt.add(vtLabel);
        window.add(vt);

        ImageIcon arenaImage = new ImageIcon(getClass().getClassLoader().getResource("arena.png"));

        JButton jArena = new JButton();

        jArena.setBackground(Color.darkGray);
        jArena.setFocusPainted(false);
        jArena.setBorder(null);
        jArena.setIcon(arenaImage);
        jArena.addActionListener(expHandler);

        arenaPanel.add(jArena);

        exp = new JPanel();
        exp.setBounds(145, 380, 250, 40);
        exp.setBackground(Color.darkGray);
        exp.setLayout(new GridLayout(2, 1)); // new GridLayout
        window.add(exp);

        expCounter = new JLabel("Experience " + expNumber);
        expCounter.setForeground(Color.white);
        expCounter.setFont(font1);

        exp.add(expCounter);

        perSec = new JLabel();
        perSec.setForeground(Color.white);
        perSec.setFont(font2);
        exp.add(perSec);

        character = new JPanel();
        character.setBounds(80, 70, 250, 250);
        character.setBackground(Color.darkGray);
        ImageIcon characterImage = new ImageIcon(getClass().getClassLoader().getResource("character.png"));
        JLabel characterIm = new JLabel();
        characterIm.setIcon(characterImage);
        character.add(characterIm);
        window.add(character);

        attack = new JPanel();
        attack.setBounds(330, 135, 80, 50);
        attack.setBackground(Color.darkGray);
        window.add(attack);

        defence = new JPanel();
        defence.setBounds(330, 195, 80, 66);
        defence.setBackground(Color.darkGray);
        window.add(defence);

        ImageIcon attackSprite = new ImageIcon(getClass().getClassLoader().getResource("attack.png"));
        ImageIcon defenceSprite = new ImageIcon(getClass().getClassLoader().getResource("defence.png"));

        JButton jAttack = new JButton();
        jAttack.setBackground(Color.darkGray);
        jAttack.setFocusPainted(false);
        jAttack.setBorder(null);
        jAttack.setIcon(attackSprite);
        jAttack.addActionListener(attackHandler);

        attack.add(jAttack);


        JButton jDefence = new JButton();
        jDefence.setBackground(Color.darkGray);
        jDefence.setFocusPainted(false);
        jDefence.setBorder(null);
        jDefence.setIcon(defenceSprite);
        jDefence.addActionListener(defenceHandler);

        defence.add(jDefence);

        stAttack = new JPanel();
        stAttack.setBounds(10, 135, 75, 50);
        stAttack.setBackground(Color.darkGray);
        window.add(stAttack);

        attackCounter = new JLabel("<html>Attack<br>" + attacks + "</html>");
        attackCounter.setForeground(Color.white);
        attackCounter.setFont(font4);
        stAttack.add(attackCounter);


        stDefence = new JPanel();
        stDefence.setBounds(10, 195, 75, 50);
        stDefence.setBackground(Color.darkGray);
        window.add(stDefence);

        defenceCounter = new JLabel("<html>Defence<br>" + defences + "</html>");
        defenceCounter.setForeground(Color.white);
        defenceCounter.setFont(font4);
        stDefence.add(defenceCounter);

        helthPanel = new JPanel();
        helthPanel.setBounds(125, 330, 175, 35);
        helthPanel.setBackground(Color.darkGray);
        window.add(helthPanel);

        healthBar = new JProgressBar(0, 1000);
        healthBar.setPreferredSize(new Dimension(175, 35));
        healthBar.setValue(1000);
        helthPanel.add(healthBar);

        hp = 1000;


        boss1 = new JPanel();
        boss1.setBounds(545, 410, 150, 35);
        boss1.setBackground(Color.white);
        window.add(boss1);

        JButton attackBoss1 = new JButton();
        attackBoss1.setBackground(Color.white);
        attackBoss1.setFocusPainted(false);
        attackBoss1.setBorder(null);

        ImageIcon boss1Image = new ImageIcon(getClass().getClassLoader().getResource("Remiko.jpg"));
        attackBoss1.setIcon(boss1Image);
        attackBoss1.addActionListener(damageHnadler1);
        boss1.add(attackBoss1);
/////////////////////////////////////////////////////////////
        boss2 = new JPanel();
        boss2.setBounds(545, 350, 150, 35);
        boss2.setBackground(Color.white);
        window.add(boss2);

        JButton attackBoss2 = new JButton();
        attackBoss2.setBackground(Color.white);
        attackBoss2.setFocusPainted(false);
        attackBoss2.setBorder(null);

        ImageIcon boss2Image = new ImageIcon(getClass().getClassLoader().getResource("Ranzero.png"));
        attackBoss2.setIcon(boss2Image);
        attackBoss2.addActionListener(damageHnadler2);
        boss2.add(attackBoss2);

//////////////////////////////////////////////////////////

        boss3 = new JPanel();
        boss3.setBounds(545, 280, 150, 35);
        boss3.setBackground(Color.white);
        window.add(boss3);

        JButton attackBoss3 = new JButton();
        attackBoss3.setBackground(Color.white);
        attackBoss3.setFocusPainted(false);
        attackBoss3.setBorder(null);

        ImageIcon boss3Image = new ImageIcon(getClass().getClassLoader().getResource("Miroku.png"));
        attackBoss3.setIcon(boss3Image);
        attackBoss3.addActionListener(damageHnadler3);
        boss3.add(attackBoss3);

//////////////////////////////////////////////////////////


        boss4 = new JPanel();
        boss4.setBounds(545, 215, 150, 35);
        boss4.setBackground(Color.white);
        window.add(boss4);

        JButton attackBoss4 = new JButton();
        attackBoss4.setBackground(Color.white);
        attackBoss4.setFocusPainted(false);
        attackBoss4.setBorder(null);

        ImageIcon boss4Image = new ImageIcon(getClass().getClassLoader().getResource("Judar.png"));
        attackBoss4.setIcon(boss4Image);
        attackBoss4.addActionListener(damageHnadler4);
        boss4.add(attackBoss4);

//////////////////////////////////////////////////////////

        tower = new JPanel();
        tower.setBounds(500, 100, 250, 400);
        tower.setBackground(Color.darkGray);


        ImageIcon towerImage = new ImageIcon(getClass().getClassLoader().getResource("tower.png"));
        JLabel towers = new JLabel();
        towers.setIcon(towerImage);
        tower.add(towers);
        window.add(tower);

//done git
        window.setVisible(true);

    }

    public void dead() {
        helthPanel.setVisible(false);
        arenaPanel.setVisible(false);
        vt.setVisible(false);
        exp.setVisible(false);
        character.setVisible(false);
        attack.setVisible(false);
        defence.setVisible(false);
        stAttack.setVisible(false);
        stDefence.setVisible(false);
        boss1.setVisible(false);
        boss2.setVisible(false);
        boss3.setVisible(false);
        boss4.setVisible(false);
        tower.setVisible(false);
        JPanel dead = new JPanel();
        dead.setBounds(0, 0, 800, 600);
        dead.setBackground(Color.black);
        JLabel deadLabel = new JLabel();
        ImageIcon deadImage = new ImageIcon(getClass().getClassLoader().getResource("dead.jpg"));
        deadLabel.setIcon(deadImage);
        dead.add(deadLabel);
        window.add(dead);

    }

    public void init() {

        JDialog d = new JDialog();
        JLabel l = new JLabel("Boss Completed");
        d.add(l);
        d.setSize(100, 100);
        d.setVisible(true);
    }

    public void init1() {

        JDialog d = new JDialog();
        JLabel l = new JLabel("No Damage Received, Boss is still alive");
        d.add(l);
        d.setSize(350, 200);
        d.setVisible(true);
    }

    public class Boss extends Boss1 {

        public Boss(String name, int attack, int defence) {
           super(name,attack,defence);
        }


    }

    public class DamageHnadler1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            damageDone1();
        }
    }

    public class DamageHnadler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            damageDone2();
        }
    }

    public class DamageHnadler3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            damageDone3();
        }
    }

    public class DamageHnadler4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            damageDone4();
        }
    }

    public void damageDone1() {
        if (boss11.attack > defences) {
            hp = hp - boss11.attack;
            healthBar.setValue(hp);
            if (hp < 1) {
                dead();
            }
        } else if (attacks > boss11.defence) {
            init();
        } else if (boss11.attack < defences) {
            init1();
        }

    }
//antonf
    public void damageDone2() {
        if (boss22.attack > defences) {
            hp = hp - boss22.attack;
            healthBar.setValue(hp);
            if (hp < 1) {
                dead();
            }
        } else if (attacks > boss22.defence) {
            init();
        } else if (boss22.attack < defences) {
            init1();
        }

    }

    public void damageDone3() {
        if (boss33.attack > defences) {
            hp = hp - boss33.attack;
            healthBar.setValue(hp);
            if (hp < 1) {
                dead();
            }
        } else if (attacks > boss33.defence) {
            init();
        } else if (boss33.attack < defences) {
            init1();
        }

    }

    public void damageDone4() {
        if (boss44.attack > defences) {
            hp = hp - boss44.attack;
            healthBar.setValue(hp);
            if (hp < 1) {
                dead();
            }
        } else if (attacks > boss44.defence) {
            init();
        } else if (boss44.attack < defences) {
            init1();
        }

    }

    public class ExpHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent event) {
            expNumber++;
            expCounter.setText("Experience " + expNumber);
        }
    }

    public class AttackHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (expNumber > 0) {
                attacks++;
                expNumber--;
                expCounter.setText("Experience " + expNumber);

            } else
                expCounter.setText("No Experience");

            attackCounter.setText("<html>Attack<br>" + attacks + "</html>");
        }
    }

    public class DefenceHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            if (expNumber > 0) {
                defences++;
                expNumber--;
                expCounter.setText("Experience " + expNumber);

            } else
                expCounter.setText("No Experience");

            defenceCounter.setText("<html>Defence<br>" + defences + "</html>");

        }
    }


    public static void main(String[] args)
    {
        new ViciousTower();



    }

}
