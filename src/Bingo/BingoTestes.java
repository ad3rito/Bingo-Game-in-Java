package Bingo;

/*
Trabalho Final

Curso:      PIPL0919
UFCD:       Formacao Pratica em contexto de Trabalho
Linguagem:  Java
Autor:      Samuel Silva e Aderito Neto
Data:       19/6/2020 - 24/06/2020
Programa:   BingoTestes
*/
//Bibliotecas

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.Random;
import javax.swing.border.*;




//PARA ANIMACOES
class Anime implements Runnable {

    // Metodo Run
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }// end methods

}// End Class Anime


//Class Publica

public class BingoTestes extends JFrame implements ActionListener{

//Dados Globais


private static final long serialVersionUID = 1L;


	//THREADS
	static Anime anime;
    static Thread thread;

		//Dados Frame
		static JFrame frameJogo = new JFrame();
		static JFrame frameVitoria = new JFrame();
		static JFrame frameMenu = new JFrame();
		static JFrame frameInstrucoes = new JFrame();
		static JFrame framePausa = new JFrame();
		static JFrame frameAbout = new JFrame();
		static int comp = 1400, alt = 800;

//Cor dasd BOrdas
		static Color cor_Bordas = new Color(50,50,50);

		//ICONS
		ImageIcon img = new ImageIcon("Images\\bolaBingo.png");


		//Para centrar o programa ao Ecra
		//Idependentemenrta das diferentes resolucoes de cada utilizador
			Toolkit tlk;
			Dimension dim;


	//Dados Jogo

	Random rand = new Random();
	static int totaljogadas = 0;
	static int pontuacao = 0;
	static int objetivo  = 15;
	static int variedade = 60;



		//Dados GUI







						//Borders

						 // Borders
				Border colorborderTabulerio = BorderFactory.createLineBorder(new Color(115, 95, 97), 3);
				Border colorborderBotoes = BorderFactory.createLineBorder(new Color(135, 105, 117), 2);
				Border colorborderIndormacao = BorderFactory.createLineBorder(new Color(209, 184, 133), 5);
				Border empty = BorderFactory.createEmptyBorder();



						 //Fonts

						 	Font Arial = new Font("Arial",Font.BOLD,26);


///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

							/////// Tabuleiro/////////////

	static JPanel norteJogo,centroJogo,sulJogo,esteJogo,oesteJogo;  //Paineis do Jogo

	// Tabuleiro
	static int num_de_botoes = 20;
	static JPanel tabuleiro;
	static JButton bt[] = new JButton[num_de_botoes];
	static JButton pausaJogo_BT_TABU;
	static int num_botaoRand;
	static String nomeBotao;
	static boolean selecionado[] = new boolean[num_de_botoes];
	static boolean elegivel[] = new boolean[num_de_botoes];

	static Color corBotao = new Color(235, 195, 207);

	static Color corLetraBotao = new Color(255, 255, 255);

	static Color corPainel_INformacao = new Color(242, 236, 172); //239,214,163

	static Color corBotao_INformacao = new Color(209, 184, 133);

	static Color corLetra_Informacao = new Color(0, 0, 0);

	// Painel da Informacao
	static JPanel informacao;
	static JLabel background_Inf_Lb;
	static JLabel lb_numRand;
	static JLabel totalJogadas_Label;
	static JLabel mostraTotalJogadas;
	static JLabel pontucao_Label;
	static JLabel mostraPontuacao;
	static JLabel bola_Random_Lb;
	static JButton gerarRand;

	static String bolas_Str[] = {
		"Images\\bola1.png",
		"Images\\bola2.png",
		"Images\\bola3.png",
		"Images\\bola4.png",
		"Images\\bola5.png",
	};
	static ImageIcon bolaRandom_Icon = new ImageIcon("");
	static ImageIcon background_Inf_Icon = new ImageIcon("Images\\background_Inf.png");


///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
	// Auxiliares


	////MUSICA

	String music_theme_Path = "Sounds\\musicaBingo.wav";
	boolean play = true, stop = false;




///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

							//////Menu Principal/////////

				// ICONS
				ImageIcon background = new ImageIcon("Images\\background.gif");



				// PAINEIS
				static JPanel centroMenu, norteMenu, sulMenu, oesteMenu, esteMenu;

				// Criar o Padrao do lado diereito para decorcao
				static JPanel primeiro_PDR_MN, segundo_PDR_MN, terceiro_PDR_MN, toalha_PDR_MN, toalha1_PDR_MN,toalha2_PDR_MN,toalha3_PDR_MN;

				/// BOTOES E LABELS QUEW CONSTITUIEM O MENU
				static JLabel background_Label;
				static JLabel background_lB_MN;
				static JButton novoJogo_BT_MN;
				static JButton informacoes_BT_MN;
				static JButton instrucoes_BT;
				static JButton about_MN;
				static JButton sair_MN;
				static JButton web1_BT_MN, web2_BT_MN;


				// Cor botoes Menu

				static Color cor_BT_MN = new Color(239, 214, 163);


	///////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////


							///MENU INSTRUCOES///

			//DIFERENTES PAINEIS A DIVIDIR
static JPanel centroINS,norteINS,sulINS,oesteINS,esteINS;
static JPanel centro_Esq_INS, centro_dir_INS;


//Dados das INSTRUCOES
static JLabel titulo_INS;

static JLabel macaco_Label;

static JButton vol_BT_INS;

static JTextArea msg_INS_1,msg_INS_2,msg_INS_3,msg_INS_4;

static Color cor_Bordas_INS = new Color(135, 105, 117);

static Color cor_Dir_INS = new Color(37, 115, 194);

static Color cor_Ltr_Dir_INS = new Color(245,245,245);
///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////


		/////////Menu do Sobre(ABOUT)//////////////////////

//BORDAS
static JPanel centroABT, centro_Dir,centro_Esq,norteABT, sulABT,oesteABT, esteABT;



//Dados DAs INDORMACOES
static JLabel titulo_ABT,QuemSomos_LB, Ideia_LB,formadores_lb,formandosImg_Label,aluno2_lb;
static JButton voltar_Menu_ABT;
static JTextArea msg_ABT_1,msg_ABT_2,msg_ABT_3,msg_ABT_4;


    //Cores
	static Color Cor_Panel_Esq = new Color(37, 115, 194);


///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////


								////PAUSA////


			//PAINEIS DE BORDAS
			static JPanel centroPAUS, nortePAUS, sulPAUS, oestePAUS, estePAUS;

			//Dados DA PAUSA
			static JLabel msgPausa_Label;
			static JLabel chill;
			static JButton voltarMenu_BT_PAUS,  retomar_BT_PAUS;

///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

						///VITORIA///

		//Paineis da Vitoria
		static JPanel centroVitoria,norteVit, sulVit, oesteVit, esteVit;

		 // Imagem da Vitoria

		 ImageIcon vitoriaLogo_Icon = new ImageIcon("Images\\vitoriaLogo.gif");
		 ImageIcon background_Icon = new ImageIcon("Images\\background.png");

    // Dados Vitoria
    static JLabel msgVitoria_Label;
    static JLabel background_Label_VIT;
    static JButton voltarMenu_BT_VIT;
    static JButton novoJogo_BT_VIT;
    static JButton sair_VIT;;

    // Cores Botoes de Pausa

    static Color corBotoes_Paus = new Color(239, 214, 163);

///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////






		//Auxiliares

		public static int ct;



///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

	//Construtor

	public BingoTestes(){

		//PARA o TEMPO ENTRE COMANDOS

		//Titulo

		//Fechar no X
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Isto nao esta optimizado, pois a janela fecha mas o programa cintinua a correr em background

		//Instanciacao para calcular as dimensoes de que estou a usar do meu computador
		tlk = getToolkit();
		dim = tlk.getScreenSize();

			//ANIMACAO
			anime = new Anime();
			thread = new Thread(anime);
			thread.start();


		///////Comecar a Musica//////////////

		
		try
        {
            File musicPath = new File(music_theme_Path);

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
               	Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

               
            }
            else{
                System.out.println("Nao encontro o Ficheiro");
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }


			//////////////////////////TABULEIROOOOO////////////

						/// centroJogo
		centroJogo = new JPanel();
		centroJogo.setLayout(null);
		centroJogo.setBackground(new Color(245, 245, 245));

		// Tabuleiro
		frameJogo.setTitle("Bingo - Jogo");
		tabuleiro = new JPanel(new GridLayout(5, 5));
		tabuleiro.setBounds(20, 20, 680, 700);
		// tabuleiro.setBorder(colorborderTabulerio);

		// centroJogo
		centroJogo = new JPanel();
		centroJogo.setLayout(null);
		centroJogo.setBackground(new Color(37, 115, 194));

		// Tabuleiro
		frameJogo.setTitle("Bingo - Jogo");
		tabuleiro = new JPanel(new GridLayout(5, 5));
		tabuleiro.setBounds(20, 20, 680, 700);
		// tabuleiro.setBorder(colorborderTabulerio);

		for (ct = 0; ct < bt.length; ct++) {

			num_botaoRand = rand.nextInt(variedade); // Aqui gera os Numeros para o tabulerio
			nomeBotao = Integer.toString(num_botaoRand);
			bt[ct] = new JButton(nomeBotao);
			bt[ct].setFont(new Font("Arial", Font.BOLD, 34));
			bt[ct].setBackground(corBotao);
			bt[ct].setForeground(corLetraBotao);
			bt[ct].setBorder(colorborderBotoes);
			bt[ct].addActionListener(this);
			bt[ct].setFocusPainted(false);
			tabuleiro.add(bt[ct]);


		}
		centroJogo.add(tabuleiro);
		frameJogo.getContentPane().add(centroJogo, BorderLayout.CENTER);

		// INformacao Lado direito///////////////////////////////////////////////////////////////////////



		informacao = new JPanel();
		informacao.setBackground(corPainel_INformacao);
		informacao.setBorder(colorborderIndormacao);
		informacao.setBounds(740, 20, 605, 700);
		informacao.setLayout(null);

		//Backgound Da INformacao de JoGo
		background_Inf_Lb = new JLabel();
		background_Inf_Lb.setBorder(empty);
		background_Inf_Lb.setIcon(background_Inf_Icon);

		background_Inf_Lb.setBounds(0,0,605,700);
		informacao.add(background_Inf_Lb);


		//Label Com  a Bola

		bola_Random_Lb = new JLabel();
		bola_Random_Lb.setBorder(empty);
		bola_Random_Lb.setOpaque(false);

		bolaRandom_Icon = new ImageIcon(bolas_Str[0]);
		bola_Random_Lb.setIcon(bolaRandom_Icon);

		bola_Random_Lb.setBounds(65, 0,600, 280);
		background_Inf_Lb.add(bola_Random_Lb);
		// LAbel COM UM NUMERO RANDOM

		lb_numRand = new JLabel(Integer.toString(rand.nextInt(variedade)), SwingConstants.CENTER);
		lb_numRand.setBorder(empty);
		lb_numRand.setOpaque(false);


		lb_numRand.setFont(new Font("Consolas", Font.BOLD, 78));
		lb_numRand.setForeground(corLetra_Informacao);
		lb_numRand.setBackground(null);

		lb_numRand.setBounds(100, 55, 300, 200);

		bola_Random_Lb.add(lb_numRand);
		centroJogo.add(informacao);

		// Botao para gerar um numero Random

		gerarRand = new JButton();
		gerarRand.setIcon(new ImageIcon("Images\\Buttons\\botaoNovaBola.png"));
		gerarRand.setContentAreaFilled(false);
		gerarRand.setBorderPainted(false);
		gerarRand.setFocusPainted(false);

		
		
		gerarRand.addActionListener(this);
		gerarRand.setBorder(empty);
	
	


		gerarRand.setBounds(190, 280, 250, 60);
		gerarRand.setFocusPainted(false);
		gerarRand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		background_Inf_Lb.add(gerarRand);

		// Botao que mostra a pausa

		pausaJogo_BT_TABU = new JButton();
		pausaJogo_BT_TABU.setIcon(new ImageIcon("Images\\Buttons\\botaoPausa.png"));
		pausaJogo_BT_TABU.setContentAreaFilled(false);
		pausaJogo_BT_TABU.setBorderPainted(false);
		pausaJogo_BT_TABU.setFocusPainted(false);

		pausaJogo_BT_TABU.setBorder(empty);

		pausaJogo_BT_TABU.setFocusPainted(false);
		pausaJogo_BT_TABU.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		pausaJogo_BT_TABU.setBounds(495, 660, 110, 35);

		pausaJogo_BT_TABU.addActionListener(this);

			background_Inf_Lb.add(pausaJogo_BT_TABU);

		// Label "Numero de Jogadas"

		totalJogadas_Label = new JLabel("Numero de jogadas", SwingConstants.CENTER);
		totalJogadas_Label.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalJogadas_Label.setBorder(empty);
		totalJogadas_Label.setOpaque(false);

		totalJogadas_Label.setForeground(corLetra_Informacao);
		

		totalJogadas_Label.setBounds(240, 380, 165, 30);

		background_Inf_Lb.add(totalJogadas_Label);

		
		// Label que mostra o numero de jogadas

		mostraTotalJogadas = new JLabel("0", SwingConstants.CENTER);
		mostraTotalJogadas.setBorder(empty);
		mostraTotalJogadas.setFont(new Font("Tahoma", Font.BOLD, 16));
		mostraTotalJogadas.setForeground(corLetra_Informacao);

		mostraTotalJogadas.setBounds(240, 400, 155, 50);

		background_Inf_Lb.add(mostraTotalJogadas);

		// Label "pontuacao total"

		pontucao_Label = new JLabel("Pontuacao", SwingConstants.CENTER);
		pontucao_Label.setFont(new Font("Tahoma", Font.BOLD, 16));

		pontucao_Label.setBorder(empty);

		pontucao_Label.setOpaque(false);
		pontucao_Label.setForeground(corLetra_Informacao);
		pontucao_Label.setBackground(corPainel_INformacao);

		pontucao_Label.setBounds(240, 480, 155, 30);

		background_Inf_Lb.add(pontucao_Label);

		// Label que mostra o total

		mostraPontuacao = new JLabel("0", SwingConstants.CENTER);
		mostraPontuacao.setFont(new Font("Tahoma", Font.BOLD, 16));
		mostraPontuacao.setBorder(empty);
		mostraPontuacao.setForeground(corLetra_Informacao);

		mostraPontuacao.setBounds(240, 500, 155, 50);

		background_Inf_Lb.add(mostraPontuacao);

		// PINTAR AS BORDAS

		// NORTE
		norteJogo = new JPanel();
		norteJogo.setBackground(cor_Bordas);
		norteJogo.setBounds(0, 0, comp, 20);
		frameJogo.getContentPane().add(norteJogo, BorderLayout.NORTH);

		sulJogo = new JPanel();
		sulJogo.setBackground(cor_Bordas);
		sulJogo.setBounds(0, 0, comp, 20);
		frameJogo.getContentPane().add(sulJogo, BorderLayout.SOUTH);

		esteJogo = new JPanel();
		esteJogo.setBackground(cor_Bordas);
		esteJogo.setBounds(0, 0, comp, 20);
		frameJogo.getContentPane().add(esteJogo, BorderLayout.EAST);

		oesteJogo = new JPanel();
		oesteJogo.setBackground(cor_Bordas);
		oesteJogo.setBounds(0, 0, comp, 20);
		frameJogo.getContentPane().add(oesteJogo, BorderLayout.WEST);




									/////////////MENU PRINCIPAL

									frameMenu.setTitle("Bingo - Menu Inicial");

        // Centro
		centroMenu = new JPanel();
		centroMenu.setLayout(null);
		centroMenu.setOpaque( false );
        centroMenu.setBackground(new Color(37, 115, 194));
        frameMenu.getContentPane().add(centroMenu, BorderLayout.CENTER);

            //LAbel com a bola de Bingo

        background_lB_MN = new JLabel();
		background_lB_MN.setIcon(background);
		background_lB_MN.setOpaque( false );
        background_lB_MN.setBounds(0, 0, 700,500);
        centroMenu.add(background_lB_MN);

            //BOtao do novo Jogo

                novoJogo_BT_MN = new JButton();
				novoJogo_BT_MN.setIcon(new ImageIcon("Images\\Buttons\\botaoNovo.png"));
				novoJogo_BT_MN.setContentAreaFilled(false);
				novoJogo_BT_MN.setBorderPainted(false);
				novoJogo_BT_MN.setFocusPainted(false);
				novoJogo_BT_MN.setBorder(empty);
				novoJogo_BT_MN.setFocusPainted(false);
				novoJogo_BT_MN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
				novoJogo_BT_MN.setBounds(290, 180, 110 ,35);
				novoJogo_BT_MN.addActionListener(this);
       			background_lB_MN.add(novoJogo_BT_MN);




            ////BOtao das instrucoes

            instrucoes_BT = new JButton();
            instrucoes_BT.setIcon(new ImageIcon("Images\\Buttons\\BotaoInstrucoes.png"));
			instrucoes_BT.setContentAreaFilled(false);
			instrucoes_BT.setBorderPainted(false);
			instrucoes_BT.setFocusPainted(false);
			instrucoes_BT.setBounds(290, 220, 110 ,35);
			instrucoes_BT.setBorder(empty);
			instrucoes_BT.setFocusPainted(false);
			instrucoes_BT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			instrucoes_BT.addActionListener(this);
            background_lB_MN.add(instrucoes_BT);







            ////BOtao do sobre (ABOUT)

                about_MN = new JButton();
				about_MN.setIcon(new ImageIcon("Images\\Buttons\\botaoSobre.png"));
				about_MN.setContentAreaFilled(false);
				about_MN.setBorderPainted(false);
				about_MN.setFocusPainted(false);
				about_MN.setBounds(290, 260, 110 ,35);
				about_MN.setBorder(empty);
				about_MN.setFocusPainted(false);
				about_MN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                about_MN.addActionListener(this);
                background_lB_MN.add(about_MN);



            ////Botao de sair

                sair_MN= new JButton();
				sair_MN.setIcon(new ImageIcon("Images\\Buttons\\botaoSair.png"));
				sair_MN.setContentAreaFilled(false);
				sair_MN.setBorderPainted(false);
				sair_MN.setFocusPainted(false);
                sair_MN.setBounds(290, 300, 110 ,35);
				sair_MN.setBorder(empty);
				sair_MN.setFocusPainted(false);
				sair_MN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sair_MN.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.gc();
                        System.exit(0);
                    }
                });
                background_lB_MN.add(sair_MN);


            ////Botao da WEB 1

                web1_BT_MN = new JButton();
                web1_BT_MN.setBackground(new Color(239, 214, 163));

				web1_BT_MN.setOpaque(false);
				web1_BT_MN.setContentAreaFilled(false);
				web1_BT_MN.setBorderPainted(false);
				web1_BT_MN.setFocusPainted(false);
				web1_BT_MN.setIcon(new ImageIcon("Images\\instagram.png"));
				web1_BT_MN.setBackground(null);
				web1_BT_MN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

				web1_BT_MN.setBounds(630, 407, 30, 30);
                web1_BT_MN.addActionListener(new ActionListener() {



                    @Override
                    public void actionPerformed(ActionEvent e) {
                       try{
                        Desktop.getDesktop().browse(new URL("https://www.instagram.com/_clout.master_/").toURI());
					} catch (Exception e2) {}
					try{
                        Desktop.getDesktop().browse(new URL("https://www.instagram.com/Samuel__2310/").toURI());
                    } catch (Exception e2) {}
                    }
                });
                background_lB_MN.add(web1_BT_MN);

  				frameMenu.getContentPane().add(centroMenu, BorderLayout.CENTER);


                //NORTE
                norteMenu = new JPanel();
                norteMenu.setBackground(cor_Bordas);
                norteMenu.setBounds(0,0,0,0);
                frameMenu.getContentPane().add(norteMenu, BorderLayout.NORTH);


                sulMenu = new JPanel();
                sulMenu.setBackground(cor_Bordas);
                sulMenu.setBounds(0,0,0,0);
                frameMenu.getContentPane().add(sulMenu, BorderLayout.SOUTH);


                esteMenu = new JPanel();
                esteMenu.setBackground(cor_Bordas);
                esteMenu.setBounds(0,0,0,0);
                frameMenu.getContentPane().add(esteMenu, BorderLayout.EAST);


                oesteMenu = new JPanel();
                oesteMenu.setBackground(cor_Bordas);
                oesteMenu.setBounds(0,0,0,0);
                frameMenu.getContentPane().add(oesteMenu, BorderLayout.WEST);




											//////MENU DAS INSTRUCOES//////////

							frameInstrucoes.setTitle("Bingo - Instrucoes");

							centroINS = new JPanel();
							centroINS.setLayout(null);
							centroINS.setBackground(new Color(230,240,220));
							frameInstrucoes.getContentPane().add(centroINS, BorderLayout.CENTER);


							centro_Esq_INS = new JPanel();
							centro_Esq_INS.setLayout(null);
							centro_Esq_INS.setBounds(10,10,250,420);
							centro_Esq_INS.setBackground(new Color(242, 236, 172));
							centroINS.add(centro_Esq_INS);

							centro_dir_INS = new JPanel();
							centro_dir_INS.setLayout(null);
							centro_dir_INS.setBackground(cor_Dir_INS);
							centro_dir_INS.setBounds(270,10,385,420);
							centroINS.add(centro_dir_INS);


							frameInstrucoes.getContentPane().add(centroINS, BorderLayout.CENTER);

								//titulo

								//titulo
								titulo_INS = new JLabel( "Instruções" , SwingConstants.LEFT);
								titulo_INS.setForeground(new Color(0,0,0));
								titulo_INS.setFont(new java.awt.Font("Tahoma", 1, 25));
								titulo_INS.setBounds(55,190, 150, 20);
								centro_Esq_INS.add(titulo_INS);

								//macaco gif
								macaco_Label = new JLabel();
								macaco_Label.setIcon(new ImageIcon("Images\\macaco.gif"));
								macaco_Label.setBounds(0,210,308,300);
								centro_Esq_INS.add(macaco_Label);

								//INSTRUCOES
								//mensagens
								msg_INS_1 = new JTextArea ("- E atribuido ao jogador um tabuleiro \n diferente a cada Jogo;");
								msg_INS_1.setFont(new Font("Tahoma", 1, 14));
								msg_INS_1.setBackground(cor_Dir_INS);
								msg_INS_1.setForeground(cor_Ltr_Dir_INS);

								msg_INS_1.setEditable(false);
								msg_INS_1.setBounds (20,110,500,35);
								centro_dir_INS.add(msg_INS_1);

								msg_INS_2 = new JTextArea ("- O jogador tem um botão que vai\n gerar um numero aleatorio;");
								msg_INS_2.setFont(new Font("Tahoma", 1, 14));
								msg_INS_2.setBackground(cor_Dir_INS);
								msg_INS_2.setForeground(cor_Ltr_Dir_INS);
								msg_INS_2.setEditable(false);
								msg_INS_2.setBounds (20,170,500,35);
								centro_dir_INS.add(msg_INS_2);

								msg_INS_3 = new JTextArea ("- O jogador tem que preencher no tabuleiro o \n numero que saiu no gerador, assim ganha 1 ponto;");
								msg_INS_3.setFont(new Font("Tahoma", 1, 14));
								msg_INS_3.setEditable(false);
								msg_INS_3.setForeground(cor_Ltr_Dir_INS);
								msg_INS_3.setBackground(cor_Dir_INS);

								msg_INS_3.setBounds (20,230,500,35);
								centro_dir_INS.add(msg_INS_3);

								msg_INS_4 = new JTextArea ("- Se o jogador conseguir fazer 15 pontos \n  ganha o jogo;");
								msg_INS_4.setFont(new Font("Tahoma", 1, 14));
								msg_INS_4.setBackground(cor_Dir_INS);
								msg_INS_4.setForeground(cor_Ltr_Dir_INS);

								msg_INS_4.setEditable(false);
								msg_INS_4.setBounds (20,300,500,35);
								centro_dir_INS.add(msg_INS_4);

								//butao para Voltar
								vol_BT_INS = new JButton();
								vol_BT_INS.setIcon(new ImageIcon("Images\\Buttons\\botaoVoltar.png"));
								vol_BT_INS.setContentAreaFilled(false);
								vol_BT_INS.setBorderPainted(false);
								vol_BT_INS.setFocusPainted(false);
					
								vol_BT_INS.setFocusPainted(false);
								vol_BT_INS.setBounds(270,380,110,35);
								vol_BT_INS.setBorder(empty);
								vol_BT_INS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
								vol_BT_INS.addActionListener(this);
								centro_dir_INS.add(vol_BT_INS);

								////Bordas
								//NORTE
										norteINS = new JPanel();
										norteINS.setBackground(cor_Bordas);
										norteINS.setBounds(0,0,0,0);
										frameInstrucoes.getContentPane().add(norteINS, BorderLayout.NORTH);


										sulINS = new JPanel();
										sulINS.setBackground(cor_Bordas);
										sulINS.setBounds(0,0,0,0);
										frameInstrucoes.getContentPane().add(sulINS, BorderLayout.SOUTH);


										esteINS = new JPanel();
										esteINS.setBackground(cor_Bordas);
										esteINS.setBounds(0,0,0,0);
										frameInstrucoes.getContentPane().add(esteINS, BorderLayout.EAST);


										oesteINS = new JPanel();
										oesteINS.setBackground(cor_Bordas);
										oesteINS.setBounds(0,0,0,0);
										frameInstrucoes.getContentPane().add(oesteINS, BorderLayout.WEST);


					///MENU DO SOBRE (ABOUT)


        frameAbout.setTitle("Bingo - Informacoes");

        centroABT = new JPanel();
        centroABT.setLayout(null);
        centroABT.setBackground(new Color(242,242,242));

        centro_Esq = new JPanel();
        centro_Esq.setLayout(null);
        centro_Esq.setBackground(Cor_Panel_Esq);
        centro_Esq.setBounds(10,10,500,520);

        centroABT.add(centro_Esq);

        centro_Dir = new JPanel();
        centro_Dir.setLayout(null);
        centro_Dir.setBackground(new Color(242, 236, 172));
        centro_Dir.setBounds(520,10,235,520);

        centroABT.add(centro_Dir);


        //titulo_ABT quem nós somos
        QuemSomos_LB = new JLabel( "Quem nós somos?" , SwingConstants.LEFT);
        QuemSomos_LB.setFont(new java.awt.Font("Tahoma", 1, 25));
        QuemSomos_LB.setBackground(Cor_Panel_Esq);
        QuemSomos_LB.setForeground(new Color(255,255,255));
        QuemSomos_LB.setBounds(20,20, 450, 35);
        frameAbout.getContentPane().add(centroABT, BorderLayout.CENTER);
        centro_Esq.add(QuemSomos_LB);

        //titulo_ABT como tivemos esta ideia

        Ideia_LB = new JLabel( "Como tivemos esta ideia" , SwingConstants.LEFT);

        Ideia_LB.setFont(new java.awt.Font("Tahoma", 1, 25));
        Ideia_LB.setBackground(Cor_Panel_Esq);
        Ideia_LB.setForeground(new Color(255,255,255));
        Ideia_LB.setBounds(20,120, 450, 35);
        frameAbout.getContentPane().add(centroABT, BorderLayout.CENTER);
        centro_Esq.add(Ideia_LB);

        //titulo_ABT formandores
        formadores_lb = new JLabel( "Formadores" , SwingConstants.LEFT);
        formadores_lb.setFont(new java.awt.Font("Tahoma", 1, 25));
        formadores_lb.setBackground(Cor_Panel_Esq);
        formadores_lb.setForeground(new Color(255,255,255));
        formadores_lb.setBounds(20,280, 450, 35);
        frameAbout.getContentPane().add(centroABT, BorderLayout.CENTER);

        centro_Esq.add(formadores_lb);
        //titulo_ABT formandos
        titulo_ABT = new JLabel( "Formandos" , SwingConstants.LEFT);
        titulo_ABT.setFont(new java.awt.Font("Tahoma", 1, 25));
        titulo_ABT.setBounds(45,20, 450, 35);
        frameAbout.getContentPane().add(centroABT, BorderLayout.CENTER);
        centro_Dir.add(titulo_ABT);

        //nomes
		formandosImg_Label = new JLabel();
		formandosImg_Label.setIcon(new ImageIcon("Images\\formandos.png"));
        formandosImg_Label.setFont(new java.awt.Font("Tahoma", 1, 25));
        formandosImg_Label.setBounds(15,15,200,500);
        frameAbout.getContentPane().add(centroABT, BorderLayout.CENTER);

        centro_Dir.add(formandosImg_Label);


        //mensagens
        msg_ABT_1 = new JTextArea("Nós Adérito Neto e Samuel Silva somos dois formandos da Atec - Academia \nde formação. E frequentamos o curso de Programador de Informática.");
        msg_ABT_1.setBounds (20,70,425,35);
        msg_ABT_1.setFont(new java.awt.Font("Tahoma", 1, 11));
        msg_ABT_1.setBackground(Cor_Panel_Esq);
        msg_ABT_1.setForeground(new Color(255,255,255));
        msg_ABT_1.setEditable(false);
        msg_ABT_1.setWrapStyleWord(true);
        centro_Esq.add(msg_ABT_1);


        msg_ABT_2 = new JTextArea ("Já existiram 2 ideias antes deste projeto: a resuloção automatica do cubo magico, \ntal como um pricelist checker. Ambos eram trabalhados em python mas como \nnenhum de nós tinha conhecimento na criação de Graphical User Interface \ndecidimos criar o jogo do bingo em Java já que tinhamos bastante conhecimento \nem shell e GUI.");
        msg_ABT_2.setBounds (25,170,470,80);
        msg_ABT_2.setFont(new java.awt.Font("Tahoma", 1, 11));
        msg_ABT_2.setBackground(Cor_Panel_Esq);
        msg_ABT_2.setForeground(new Color(255,255,255));
        msg_ABT_2.setEditable(false);
        msg_ABT_2.setWrapStyleWord(true);

        centro_Esq.add(msg_ABT_2);

        msg_ABT_3 = new JTextArea ("Luís Silva\nCândida Jorge");
        msg_ABT_3.setBounds (25,330,85,35);
        msg_ABT_3.setFont(new java.awt.Font("Tahoma", 1, 11));
        msg_ABT_3.setBackground(Cor_Panel_Esq);
        msg_ABT_3.setForeground(new Color(255,255,255));
        msg_ABT_3.setEditable(false);
        msg_ABT_3.setWrapStyleWord(true);
        centro_Esq.add(msg_ABT_3);




         //butao para voltar
        voltar_Menu_ABT = new JButton();
        voltar_Menu_ABT.setIcon(new ImageIcon("Images\\Buttons\\botaoVoltar.png"));
		voltar_Menu_ABT.setContentAreaFilled(false);
		voltar_Menu_ABT.setBorderPainted(false);
		voltar_Menu_ABT.setFocusPainted(false);

		voltar_Menu_ABT.setFocusPainted(false);
								
        voltar_Menu_ABT.setFocusPainted(false);
        voltar_Menu_ABT.setBounds(380,485,110,35);
        voltar_Menu_ABT.setBorder(empty);
        voltar_Menu_ABT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        voltar_Menu_ABT.addActionListener(this);

        centro_Esq.add(voltar_Menu_ABT);


                //NORTE
                norteABT = new JPanel();
                norteABT.setBackground(cor_Bordas);
                norteABT.setBounds(0,0,0,0);
                frameAbout.getContentPane().add(norteABT, BorderLayout.NORTH);


                sulABT = new JPanel();
                sulABT.setBackground(cor_Bordas);
                sulABT.setBounds(0,0,0,0);
                frameAbout.getContentPane().add(sulABT, BorderLayout.SOUTH);


                esteABT = new JPanel();
                esteABT.setBackground(cor_Bordas);
                esteABT.setBounds(0,0,0,0);
                frameAbout.getContentPane().add(esteABT, BorderLayout.EAST);


                oesteABT = new JPanel();
                oesteABT.setBackground(cor_Bordas);
                oesteABT.setBounds(0,0,0,0);
                frameAbout.getContentPane().add(oesteABT, BorderLayout.WEST);





					///PAUSAAAA//////////////////////////////////////////////////////

					framePausa.setTitle("Bingo - Pausa");
					centroPAUS = new JPanel();
					centroPAUS.setLayout(null);
					centroPAUS.setBackground(new Color(106, 150, 195));
					framePausa.getContentPane().add(centroPAUS, BorderLayout.CENTER);

					//chill
					chill = new JLabel();
					chill.setIcon(new ImageIcon("Images\\chill.gif"));
					chill.setBounds(240,0,200,200);
					centroPAUS.add(chill);

					//Voltar ao Menu Botao na Vitoria
					//Voltar ao Menu Botao na Vitoria
					voltarMenu_BT_PAUS = new JButton();
					
					voltarMenu_BT_PAUS.setIcon(new ImageIcon("Images\\Buttons\\botaoVoltarMenu.png"));
					voltarMenu_BT_PAUS.setContentAreaFilled(false);
					voltarMenu_BT_PAUS.setBorderPainted(false);
					voltarMenu_BT_PAUS.setFocusPainted(false);
					voltarMenu_BT_PAUS.setFocusPainted(false);
					voltarMenu_BT_PAUS.setBorder(empty);
					voltarMenu_BT_PAUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
					
					voltarMenu_BT_PAUS.setBounds(15,165, 175, 55);
					
					voltarMenu_BT_PAUS.addActionListener(this);

					centroPAUS.add(voltarMenu_BT_PAUS);





					//Retomar Jogo Botao na Pausa
					retomar_BT_PAUS = new JButton();
					retomar_BT_PAUS.setIcon(new ImageIcon("Images\\Buttons\\botaoRetomar.png"));
					retomar_BT_PAUS.setContentAreaFilled(false);
					retomar_BT_PAUS.setBorderPainted(false);
					retomar_BT_PAUS.setFocusPainted(false);
					
					retomar_BT_PAUS.addActionListener(this);
					retomar_BT_PAUS.setBorder(empty);
					retomar_BT_PAUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
					
					retomar_BT_PAUS.setBounds(15,100, 170, 45);

					validate();

						retomar_BT_PAUS.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e){

						framePausa.dispose();


					}

					});

					centroPAUS.add( retomar_BT_PAUS);



					////Mostrar O Titulo Na PAUSA
					msgPausa_Label = new JLabel();
					msgPausa_Label.setIcon(new ImageIcon("Images\\Buttons\\Pausa_Title.png"));
					msgPausa_Label.setOpaque(false);
					centroPAUS.add(msgPausa_Label);
					msgPausa_Label.setBounds(10,5, 180, 70);






					//NORTE
					nortePAUS = new JPanel();
					nortePAUS.setBackground(cor_Bordas);
					nortePAUS.setBounds(0,0,0,0);
					framePausa.getContentPane().add(nortePAUS, BorderLayout.NORTH);


					sulPAUS = new JPanel();
					sulPAUS.setBackground(cor_Bordas);
					sulPAUS.setBounds(0,0,0,0);
					framePausa.getContentPane().add(sulPAUS, BorderLayout.SOUTH);


					estePAUS = new JPanel();
					estePAUS.setBackground(cor_Bordas);
					estePAUS.setBounds(0,0,0,0);
					framePausa.getContentPane().add(estePAUS, BorderLayout.EAST);


					estePAUS = new JPanel();
					estePAUS.setBackground(cor_Bordas);
					estePAUS.setBounds(0,0,0,0);
					framePausa.getContentPane().add(estePAUS, BorderLayout.WEST);














				/////////MENUUUU DA VITORIA

				frameVitoria.setTitle("Bingo - Vitória");
				centroVitoria = new JPanel();
        		centroVitoria.setLayout(null);
        		centroVitoria.setBackground(new Color(37, 115, 194));



				// _______________________________Imagens__________________________________________

				msgVitoria_Label = new JLabel();
				msgVitoria_Label.setIcon(vitoriaLogo_Icon);
				msgVitoria_Label.setBounds(175, 0, 360, 200);

				centroVitoria.add(msgVitoria_Label);

				frameVitoria.getContentPane().add(centroVitoria, BorderLayout.CENTER);

				 // _______________________________Imagens__________________________________________


				// Novo Jogo Botao na Vitoria
				novoJogo_BT_VIT = new JButton();
				novoJogo_BT_VIT.setIcon(new ImageIcon("Images\\Buttons\\botaoNovo.png"));
				novoJogo_BT_VIT.setContentAreaFilled(false);
				novoJogo_BT_VIT.setBorderPainted(false);
				novoJogo_BT_VIT.setFocusPainted(false);
				
				novoJogo_BT_VIT.setBorder(empty);
				
				novoJogo_BT_VIT.setFocusPainted(false);
				novoJogo_BT_VIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

				novoJogo_BT_VIT.addActionListener(this);
				novoJogo_BT_VIT.setBounds(20, 30, 110, 35);
				centroVitoria.add(novoJogo_BT_VIT);


				// Voltar ao Menu Botao na Vitoria
				voltarMenu_BT_VIT = new JButton();
				voltarMenu_BT_VIT.setIcon(new ImageIcon("Images\\Buttons\\botaoMenu.png"));
				voltarMenu_BT_VIT.setContentAreaFilled(false);
				voltarMenu_BT_VIT.setBorderPainted(false);
				voltarMenu_BT_VIT.setFocusPainted(false);
				voltarMenu_BT_VIT.setBorder(empty);
				
				voltarMenu_BT_VIT.setFocusPainted(false);
				voltarMenu_BT_VIT.setBounds(20, 80, 110, 45);
				voltarMenu_BT_VIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

				voltarMenu_BT_VIT.addActionListener(this);

				centroVitoria.add(voltarMenu_BT_VIT);



				 // botao para sair
				 sair_VIT = new JButton();
				 sair_VIT.setIcon(new ImageIcon("Images\\Buttons\\botaoSair.png"));
				 sair_VIT.setContentAreaFilled(false);
				 sair_VIT.setBorderPainted(false);
				 sair_VIT.setFocusPainted(false);
				 sair_VIT.setFocusPainted(false);
				 
				 sair_VIT.setBorder(empty);
				 sair_VIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			
	 			sair_VIT.setBounds(20, 130, 110, 45);
				 sair_VIT.addActionListener(new ActionListener() {

					 @Override
					 public void actionPerformed(ActionEvent e) {
						 System.gc();
						 System.exit(0);
					 }
				 });
				 centroVitoria.add(sair_VIT);


				//NORTE
				norteVit = new JPanel();
				norteVit.setBackground(cor_Bordas);
				norteVit.setBounds(0,0,0,0);
				frameVitoria.getContentPane().add(norteVit, BorderLayout.NORTH);


				sulVit = new JPanel();
				sulVit.setBackground(cor_Bordas);
				sulVit.setBounds(0,0,0,0);
				frameVitoria.getContentPane().add(sulVit, BorderLayout.SOUTH);


				esteVit = new JPanel();
				esteVit.setBackground(cor_Bordas);
				esteVit.setBounds(0,0,0,0);
				frameVitoria.getContentPane().add(esteVit, BorderLayout.EAST);


				oesteVit = new JPanel();
				oesteVit.setBackground(cor_Bordas);
				oesteVit.setBounds(0,0,0,0);
				frameVitoria.getContentPane().add(oesteVit, BorderLayout.WEST);



		//Garantir que todos os botoes nao estao selecionados  e que sao elegiveis para carregar
		for(ct = 0;ct<num_de_botoes;ct++){
			selecionado[ct] = false;
			elegivel[ct] = true;
		}//end

		//Frame


		//FRame do JOGO
			frameJogo.setResizable(false);
			frameJogo.setBounds( dim.width / 2 - comp/2, dim.height / 2 - alt/2,comp,alt);
			frameJogo.setVisible(false);
			frameJogo.setIconImage(img.getImage());


		//Frame do MENU
			frameMenu.setBounds( dim.width / 2 - 700/2, dim.height / 2 - 500/2,700,500);
			frameMenu.setResizable(false);
			frameMenu.setVisible(true);
		frameMenu.setIconImage(img.getImage());

		//Frame das Instrucoes
		frameInstrucoes.setBounds( dim.width / 2 - 700/2, dim.height / 2 - 500/2,700,500);
		frameInstrucoes.setResizable(false);
		frameInstrucoes.setVisible(false);
		frameInstrucoes.setIconImage(img.getImage());

		//FRame sobre(ABOUT)
		frameAbout.setBounds( dim.width / 2 - 800/2, dim.height / 2 - 600/2,800,600);
		frameAbout.setResizable(false);
        frameAbout.setVisible(false);
	frameAbout.setIconImage(img.getImage());


		//Frame da Pausa
		framePausa.setBounds( dim.width / 2 - 500/2, dim.height / 2 - 300/2,500,300);
		framePausa.setResizable(false);
		framePausa.setVisible(false);
	framePausa.setIconImage(img.getImage());


		//Frame da vitoria
			frameVitoria.setBounds( dim.width / 2 - 500/2, dim.height / 2 - 300/2,600,250);
			frameVitoria.setResizable(false);
			frameVitoria.setVisible(false);
		frameVitoria.setIconImage(img.getImage());


	}//End Construtor


//Metodos
	public void actionPerformed(final ActionEvent e){

			 int numLabel;
			 int nAtualBotao,nAtualGerador;
			 int bolaEscolhida;



		///Gerar OS Numeros No Label
		if(e.getSource() == gerarRand){

			bolaEscolhida = rand.nextInt(4);

			switch(bolaEscolhida){
				case 0:
					bolaRandom_Icon = new ImageIcon(bolas_Str[bolaEscolhida]);
					bola_Random_Lb.setIcon(bolaRandom_Icon);
					break;
				case 1:
					bolaRandom_Icon = new ImageIcon(bolas_Str[bolaEscolhida]);
					bola_Random_Lb.setIcon(bolaRandom_Icon);
					break;
				case 2:
					bolaRandom_Icon = new ImageIcon(bolas_Str[bolaEscolhida]);
					bola_Random_Lb.setIcon(bolaRandom_Icon);
					break;
				case 3:
					bolaRandom_Icon = new ImageIcon(bolas_Str[bolaEscolhida]);
					bola_Random_Lb.setIcon(bolaRandom_Icon);
					break;
				case 4:
					bolaRandom_Icon = new ImageIcon(bolas_Str[bolaEscolhida]);
					bola_Random_Lb.setIcon(bolaRandom_Icon);
					break;

				default:
					bolaRandom_Icon = new ImageIcon(bolas_Str[0]);
					bola_Random_Lb.setIcon(bolaRandom_Icon);
					break;
			}



			numLabel = rand.nextInt(variedade);
			lb_numRand.setText("");
			lb_numRand.setText(Integer.toString(numLabel));


			//Somar Jogadas
			totaljogadas++;
			mostraTotalJogadas.setText("");
			mostraTotalJogadas.setText(Integer.toString(totaljogadas));
			mostraTotalJogadas.setForeground(Color.BLACK);



		}//End gerar Botoes



				///////////////////////////////////////////////////////////////////////////////////////

					/////////////////////////////////SO PARA O PROGRAMADORR!!!!!!!!!!!!///////////
												//PREENCHER AUTOMATICO PARA POUPAR TYEMPO

										/*
												for (ct =0; ct<num_de_botoes;ct++){

											nAtualBotao = Integer.parseInt(bt[ct].getText());
											nAtualGerador = Integer.parseInt(lb_numRand.getText());

											if( nAtualBotao == nAtualGerador ){

												selecionado[ct] = !selecionado[ct];
											if (selecionado[ct] == true && elegivel[ct] == true){

												bt[ct].setBackground(new Color(255,194,159));
												pontuacao++;
												mostraPontuacao.setText("");
												mostraPontuacao.setText(Integer.toString(pontuacao));
												mostraPontuacao.setForeground(Color.BLACK);
												elegivel[ct] = false;

											}//end if 3

										}//END IF2
									}//end if1
										*/

						///////////////////////////////////////////////////////////////////////////////////////


			///Selecionar Butoes

			for (ct =0; ct<num_de_botoes;ct++){
				if(e.getSource() == bt[ct]){

					nAtualBotao = Integer.parseInt(bt[ct].getText());
					nAtualGerador = Integer.parseInt(lb_numRand.getText());

					if( nAtualBotao == nAtualGerador ){

						selecionado[ct] = !selecionado[ct];
					if (selecionado[ct] == true && elegivel[ct] == true){

						bt[ct].setBackground(new Color(255,194,159));
						pontuacao++;
						mostraPontuacao.setText("");
						mostraPontuacao.setText(Integer.toString(pontuacao));
						mostraPontuacao.setForeground(Color.BLACK);
						elegivel[ct] = false;

					}//end if 3

				}//END IF2
			}//end if1
				}//END selecionar botoes
					/////////////////////////////////////

					///APARECER E DESAPARECER AS FRAMES


					//NOVO JOGO
					if (e.getSource() == novoJogo_BT_MN || e.getSource() == novoJogo_BT_VIT){
						frameMenu.setVisible(false);
						frameVitoria.setVisible(false);
						framePausa.setVisible(false);

						//Garantir que todos os botoes nao estao selecionados
						for(ct = 0;ct<num_de_botoes;ct++){
							selecionado[ct] = false;
							bt[ct].setBackground(corBotao);
							bt[ct].setFont(new Font("Arial",Font.BOLD, 30));


						}//end

						lb_numRand.setText(Integer.toString(rand.nextInt(variedade))); //Para a Label recomecar com um Numero diferente

						pontuacao = 0;
						mostraPontuacao.setText("");
						mostraPontuacao.setText(Integer.toString(pontuacao));
						mostraPontuacao.setForeground(Color.BLACK);

						totaljogadas = 0;
						mostraTotalJogadas.setText("");
						mostraTotalJogadas.setText(Integer.toString(totaljogadas));

						//PARA UM Novo Tabuleiro
						for(ct = 0;ct<bt.length;ct++){

							num_botaoRand = rand.nextInt(variedade); //Aqui gera os Numeros para o tabulerio
							nomeBotao = Integer.toString(num_botaoRand);
							bt[ct].setText(nomeBotao);

						}





						frameJogo.setVisible(true);
					}//END IF QUE ACONTECE AO CLICAR NOVO JOGO




						//Botao das Instrucoes

						if(e.getSource() == instrucoes_BT){

							frameMenu.setVisible(false);
							frameJogo.setVisible(false);
							frameVitoria.setVisible(false);
							frameInstrucoes.setVisible(true);
							framePausa.setVisible(false);

						}

						if(e.getSource() == instrucoes_BT){

							frameMenu.setVisible(false);
							frameJogo.setVisible(false);
							frameVitoria.setVisible(false);
							frameInstrucoes.setVisible(true);
							framePausa.setVisible(false);

						}


						///BOTAO DO SOBRE(ABOUT)

						if(e.getSource() == about_MN){



							frameMenu.setVisible(false);
							frameJogo.setVisible(false);
							frameVitoria.setVisible(false);
							frameInstrucoes.setVisible(false);
							framePausa.setVisible(false);
							frameAbout.setVisible(true);

						}


						//////Aparecer a Pausa

						if(e.getSource() == pausaJogo_BT_TABU){

							frameMenu.setVisible(false);
							frameJogo.setVisible(true);
							frameVitoria.setVisible(false);
							frameInstrucoes.setVisible(false);
							framePausa.setVisible(true);

						}

						//VOLTAR  PARA O MENU

						if(e.getSource() == vol_BT_INS || e.getSource() == voltarMenu_BT_PAUS || e.getSource() == voltarMenu_BT_VIT || e.getSource() == voltar_Menu_ABT ){

							pontuacao = 0;

							frameJogo.setVisible(false);
							frameVitoria.setVisible(false);
							frameInstrucoes.setVisible(false);

							framePausa.setVisible(false);
							frameAbout.setVisible(false);

							frameMenu.setVisible(true);

						}


						//BOTAO DE SAIR

						if(e.getSource() == sair_MN || e.getSource() == sair_VIT ){

							System.gc();
							System.exit(0);
						}


					if(pontuacao == objetivo){

						frameJogo.setVisible(false);
						frameVitoria.setVisible(true);
					}





}//end








//main
public static void main (final String [] args){

final BingoTestes app = new BingoTestes();

app.addWindowListener( new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
		
		
		
		
		
	}
});

}//end Main
}//End Class