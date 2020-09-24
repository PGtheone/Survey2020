package com.compuconsult.app.enquete2020;

import com.compuconsult.app.enquete2020.model.Answer;
import com.compuconsult.app.enquete2020.model.Question;

import java.util.ArrayList;
import java.util.List;

public class Dummy {

    private List<Question> questions = new ArrayList<>();

    public Dummy() {
        initQuestion();
    }

    public void initQuestion(){
        //1
        List<Answer> answerList = new ArrayList<>();
        Question question1 = new Question( "Quel est votre sexe ?", false);
        Answer answer1 = new Answer( 1L,"Féminin");
        Answer answer2 = new Answer( 2L,"Masculin");
        answerList.add(answer1);
        answerList.add(answer2);
        question1.setAnswerList(answerList);
        questions.add(question1);

//2
        answerList = new ArrayList<>();
        Question question2 = new Question( "Quelle est votre tranche d'âge ?", false);
        Answer answerq21 = new Answer( 1L, "Moins de 25 ans");
        Answer answerq22 = new Answer( 2L, "Entre 25 et 35 ans");
        Answer answerq23 = new Answer( 3L,"Entre 35 et 50 ans");
        Answer answerq24 = new Answer( 4L, "Entre 50 et 65 ans");
        Answer answerq25 = new Answer( 5L, "Plus de 65 ans");
        Answer answerq26 = new Answer( 55L,"Je ne sais pas");
        Answer answerq27 = new Answer( 99L,"Aucune réponse");
        answerList.add(answerq21);
        answerList.add(answerq22);
        answerList.add(answerq23);
        answerList.add(answerq24);
        answerList.add(answerq25);
        answerList.add(answerq26);
        answerList.add(answerq27);
        question2.setAnswerList(answerList);
        questions.add(question2);

      //3
        answerList = new ArrayList<>();
        Question question3 = new Question( "Quelle est votre religion ?", false);
        Answer answerq31 = new Answer( 1L,"Adventiste");
        Answer answerq32 = new Answer( 2L,"Baptsite");
        Answer answerq33 = new Answer( 3L,"Catholique");
        Answer answerq34 = new Answer( 4L,"Musulman");
        Answer answerq35 = new Answer( 5L,"Pentecôtiste");
        Answer answerq36 = new Answer( 6L,"Témoin de Jéhovah");
        Answer answerq37 = new Answer( 7L,"Vodouisant");
        Answer answerq38 = new Answer( 8L,"Athée");
        Answer answerq39 = new Answer( 55L,"Je ne sais pas");
        Answer answerq310 = new Answer( 66L, "Autre");
        Answer answerq311 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq31);
        answerList.add(answerq32);
        answerList.add(answerq33);
        answerList.add(answerq34);
        answerList.add(answerq35);
        answerList.add(answerq36);
        answerList.add(answerq37);
        answerList.add(answerq38);
        answerList.add(answerq39);
        answerList.add(answerq310);
        answerList.add(answerq311);
        question3.setAnswerList(answerList);
        questions.add(question3);

        //4
        answerList = new ArrayList<>();
        Question question4 = new Question( "Quelle est votre département de naissance ?", false);
        Answer answerq41 = new Answer( 1L,"Artibonite");
        Answer answerq42 = new Answer( 2L,"Centre");
        Answer answerq43 = new Answer( 3L,"Grand-Anse");
        Answer answerq44 = new Answer( 4L,"Nippes");
        Answer answerq45 = new Answer( 5L,"Nord");
        Answer answerq46 = new Answer( 6L,"Nord-est");
        Answer answerq47 = new Answer( 7L,"Nord-ouest");
        Answer answerq48 = new Answer( 8L,"Ouest");
        Answer answerq49 = new Answer( 9L,"Sud");
        Answer answerq410 = new Answer( 10L,"Sud-est");
        Answer answerq411 = new Answer( 11L,"Sud-ouest");
        Answer answerq412 = new Answer( 55L,"Je ne sais pas");
        Answer answerq413 = new Answer( 66L, "Autre");
        Answer answerq414 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq41);
        answerList.add(answerq42);
        answerList.add(answerq43);
        answerList.add(answerq44);
        answerList.add(answerq45);
        answerList.add(answerq46);
        answerList.add(answerq47);
        answerList.add(answerq48);
        answerList.add(answerq49);
        answerList.add(answerq410);
        answerList.add(answerq411);
        answerList.add(answerq412);
        answerList.add(answerq413);
        answerList.add(answerq414);
        question4.setAnswerList(answerList);
        questions.add(question4);


        //5
        answerList = new ArrayList<>();
        Question question5 = new Question( "Où vivez-vous actuellement ?", false);
        Answer answerq51 = new Answer( 1L,"Haïti");
        Answer answerq52 = new Answer( 2L,"Etranger");
        Answer answerq53 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq51);
        answerList.add(answerq52);
        answerList.add(answerq53);
        question5.setAnswerList(answerList);
        questions.add(question5);


        //6
        answerList = new ArrayList<>();
        Question question6 = new Question( "Quel est votre statut aujourd'hui ?", false);
        Answer answerq61 = new Answer( 1L,"Ecolier");
        Answer answerq62 = new Answer( 2L,"Etudiant");
        Answer answerq63 = new Answer( 3L,"Ouvrier");
        Answer answerq64 = new Answer( 4L,"Chômeur");
        Answer answerq65 = new Answer( 5L,"Entrepreneur");
        Answer answerq66 = new Answer( 6L,"Fonctionnaire");
        Answer answerq67 = new Answer( 7L,"Artisan");
        Answer answerq68 = new Answer( 8L,"Professionnel");
        Answer answerq69 = new Answer( 9L,"Agriculteur");
        Answer answerq610 = new Answer( 10L,"Commerçant");
        Answer answerq612 = new Answer( 55L,"Je ne sais pas");
        Answer answerq613 = new Answer( 66L, "Autre");
        Answer answerq614 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq61);
        answerList.add(answerq62);
        answerList.add(answerq63);
        answerList.add(answerq64);
        answerList.add(answerq65);
        answerList.add(answerq66);
        answerList.add(answerq67);
        answerList.add(answerq68);
        answerList.add(answerq69);
        answerList.add(answerq610);
        answerList.add(answerq612);
        answerList.add(answerq613);
        answerList.add(answerq614);
        question6.setAnswerList(answerList);
        questions.add(question6);


//7
        answerList = new ArrayList<>();
        Question question7 = new Question( "Dans quel secteur d’activité évoluez-vous  ?", false);
        Answer answerq71 = new Answer( 1L,"Fonction publique ");
        Answer answerq72 = new Answer( 2L,"Industrie");
        Answer answerq73 = new Answer( 3L,"Services");
        Answer answerq74 = new Answer( 4L,"Agriculture");
        Answer answerq75 = new Answer( 5L,"Commerce");
        Answer answerq76 = new Answer( 6L,"Enseignement");
        Answer answerq77 = new Answer( 7L,"Aucun");
        Answer answerq78 = new Answer( 8L,"Construction");
        Answer answerq79 = new Answer( 9L,"Santé");
        Answer answerq712 = new Answer( 55L,"Je ne sais pas");
        Answer answerq713 = new Answer( 66L, "Autre");
        Answer answerq714 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq71);
        answerList.add(answerq72);
        answerList.add(answerq73);
        answerList.add(answerq74);
        answerList.add(answerq75);
        answerList.add(answerq76);
        answerList.add(answerq77);
        answerList.add(answerq78);
        answerList.add(answerq79);
        answerList.add(answerq712);
        answerList.add(answerq713);
        answerList.add(answerq714);
        question7.setAnswerList(answerList);
        questions.add(question7);


        //8
        answerList = new ArrayList<>();
        Question question8 = new Question( "Vous sentez-vous bien en Haïti ?", false);
        Answer answerq81 = new Answer( 1L,"Oui");
        Answer answerq82 = new Answer( 2L,"Non");
        Answer answerq83 = new Answer( 55L,"Je ne sais pas");
        Answer answerq84 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq81);
        answerList.add(answerq82);
        answerList.add(answerq83);
        answerList.add(answerq84);
        question8.setAnswerList(answerList);
        questions.add(question8);


        //9
        answerList = new ArrayList<>();
        Question question9 = new Question( "(Si la réponse à la question 8 est oui) Indiquez trois (3) raisons", true);
        Answer answerq91 = new Answer( 1L,"On est libre de faire ce qu’on veut");
        Answer answerq92 = new Answer( 2L,"C’est mon pays (Lakay se lakay !)");
        Answer answerq93 = new Answer( 3L,"Je ne peux aller nulle part d’autre  ");
        Answer answerq94 = new Answer( 4L," Je crois encore dans l’avenir");
        Answer answerq95 = new Answer( 5L,"Le climat  ");
        Answer answerq96 = new Answer( 6L,"C’est à nous de changer le pays, pas aux autres !");
        Answer answerq97 = new Answer( 7L," La solidarité");
        Answer answerq98 = new Answer( 8L,"Le fisc ne nous emmerde pas");
        Answer answerq912 = new Answer( 55L,"Je ne sais pas");
        Answer answerq913 = new Answer( 66L, "Autre");
        Answer answerq914 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq91);
        answerList.add(answerq92);
        answerList.add(answerq93);
        answerList.add(answerq94);
        answerList.add(answerq95);
        answerList.add(answerq96);
        answerList.add(answerq97);
        answerList.add(answerq98);
        answerList.add(answerq912);
        answerList.add(answerq913);
        answerList.add(answerq914);
        question9.setAnswerList(answerList);
        questions.add(question9);

        //10
        answerList = new ArrayList<>();
        Question question10 = new Question( "(Si la réponse à la question 8 est non) Indiquez trois (3) raisons", true);
        Answer answerq101 = new Answer( 1L,"Trop de misère");
        Answer answerq102 = new Answer( 2L,"Pas de services");
        Answer answerq103 = new Answer( 3L,"Trop d’instabilité");
        Answer answerq104 = new Answer( 4L,"On ne peut pas planifier");
        Answer answerq105 = new Answer( 5L," Pas moyen d’investir");
        Answer answerq106 = new Answer( 6L," Insécurité");
        Answer answerq107 = new Answer( 7L,"Pas d’avenir dans ce pays");
        Answer answerq108 = new Answer( 8L,"Pas moyen d’élever les enfants");
        Answer answerq1012 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1013 = new Answer( 66L, "Autre");
        Answer answerq1014 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq101);
        answerList.add(answerq102);
        answerList.add(answerq103);
        answerList.add(answerq104);
        answerList.add(answerq105);
        answerList.add(answerq106);
        answerList.add(answerq107);
        answerList.add(answerq108);
        answerList.add(answerq1012);
        answerList.add(answerq1013);
        answerList.add(answerq1014);
        question10.setAnswerList(answerList);
        questions.add(question10);

        //11
        answerList = new ArrayList<>();
        Question question11 = new Question( "(Si la réponse à la question 8 est non) Êtes-vous prêt à laisser le pays ?", false);
        Answer answerq111 = new Answer( 1L,"Oui");
        Answer answerq112 = new Answer( 2L,"Non");
        Answer answerq1112 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1114 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq111);
        answerList.add(answerq112);
        answerList.add(answerq1112);
        answerList.add(answerq1114);
        question11.setAnswerList(answerList);
        questions.add(question11);

        //12
        answerList = new ArrayList<>();
        Question question12 = new Question( "(Si la réponse à la question 11 est non) Indiquez trois (3) souhaits qui, selon vous, pourraient améliorer votre quotidien.", true);
        Answer answerq121 = new Answer( 1L,"Changement de système");
        Answer answerq122 = new Answer( 2L,"Plus d’infrastructures");
        Answer answerq123 = new Answer( 3L,"Plus de justice");
        Answer answerq124 = new Answer( 4L,"Plus de sanctions");
        Answer answerq125 = new Answer( 5L,"Plus d’ordre");
        Answer answerq126 = new Answer( 6L,"Production nationale");
        Answer answerq127 = new Answer( 7L,"Plus d’emplois");
        Answer answerq128 = new Answer( 8L," Meilleure éducation");
        Answer answerq1212 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1213 = new Answer( 66L, "Autre");
        Answer answerq1214 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq121);
        answerList.add(answerq122);
        answerList.add(answerq123);
        answerList.add(answerq124);
        answerList.add(answerq125);
        answerList.add(answerq126);
        answerList.add(answerq127);
        answerList.add(answerq128);
        answerList.add(answerq1212);
        answerList.add(answerq1213);
        answerList.add(answerq1214);
        question12.setAnswerList(answerList);
        questions.add(question12);

        //13
        answerList = new ArrayList<>();
        Question question13 = new Question( "Croyez-vous qu’il est nécessaire d’amender la Constitution ?", false);
        Answer answerq131 = new Answer( 1L,"Oui");
        Answer answerq132 = new Answer( 2L,"Non");
        Answer answerq1312 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1314 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq131);
        answerList.add(answerq132);
        answerList.add(answerq1312);
        answerList.add(answerq1314);
        question13.setAnswerList(answerList);
        questions.add(question13);

        //14
        answerList = new ArrayList<>();
        Question question14 = new Question( "Pensez-vous que le pays a besoin d’un Parlement ?", false);
        Answer answerq141 = new Answer( 1L,"Oui");
        Answer answerq142 = new Answer( 2L,"Non");
        Answer answerq1412 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1414 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq141);
        answerList.add(answerq142);
        answerList.add(answerq1412);
        answerList.add(answerq1414);
        question14.setAnswerList(answerList);
        questions.add(question14);

        //15
        answerList = new ArrayList<>();
        Question question15 = new Question( "Laquelle de ces situations serait plus susceptible de donner plus de résultats pour le pays ?", false);
        Answer answerq151 = new Answer( 1L,"des Responsables efficaces");
        Answer answerq152 = new Answer( 2L,"des Institutions efficaces ");
        Answer answerq153 = new Answer( 3L,"des Responsables et des Institutions efficaces");
        Answer answerq154 = new Answer( 4L,"Aucun");
        Answer answerq1512 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1513 = new Answer( 66L, "Autre");
        Answer answerq1514 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq151);
        answerList.add(answerq152);
        answerList.add(answerq153);
        answerList.add(answerq154);
        answerList.add(answerq1512);
        answerList.add(answerq1513);
        answerList.add(answerq1514);
        question15.setAnswerList(answerList);
        questions.add(question15);


        //16
        answerList = new ArrayList<>();
        Question question16 = new Question( "Choisissez trois (3) réponses qui traduisent votre perception des élections en Haïti.", true);
        Answer answerq161 = new Answer( 1L,"Le pilier de la démocratie");
        Answer answerq162 = new Answer( 2L,"Cela ne nous concerne pas ");
        Answer answerq163 = new Answer( 3L,"Un mal nécessaire");
        Answer answerq164 = new Answer( 4L,"Une grosse affaire");
        Answer answerq165 = new Answer( 5L,"Cela ne nous mènera nulle part");
        Answer answerq166 = new Answer( 6L,"De l’argent jeté");
        Answer answerq167 = new Answer( 7L,"Notre unique chance");
        Answer answerq168 = new Answer( 8L,"Le générateur de crises par excellence");
        Answer answerq1612 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1613 = new Answer( 66L, "Autre");
        Answer answerq1614 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq161);
        answerList.add(answerq162);
        answerList.add(answerq163);
        answerList.add(answerq164);
        answerList.add(answerq165);
        answerList.add(answerq166);
        answerList.add(answerq167);
        answerList.add(answerq168);
        answerList.add(answerq1612);
        answerList.add(answerq1613);
        answerList.add(answerq1614);
        question16.setAnswerList(answerList);
        questions.add(question16);


        //17
        answerList = new ArrayList<>();
        Question question17 = new Question( "Pensez-vous que les élections sont possibles aujourd’hui en Haïti ?", false);
        Answer answerq171 = new Answer( 1L,"Oui");
        Answer answerq172 = new Answer( 2L,"Non");
        Answer answerq1712 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1714 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq171);
        answerList.add(answerq172);
        answerList.add(answerq1712);
        answerList.add(answerq1714);
        question17.setAnswerList(answerList);
        questions.add(question17);



        //18
        answerList = new ArrayList<>();
        Question question18 = new Question( "(Si la réponse à la question 17 est non) Indiquez trois (3) raisons", true);
        Answer answerq181 = new Answer( 1L,"Le CEP n’inspire pas confiance");
        Answer answerq182 = new Answer( 2L,"L’identification des électeurs est incomplète");
        Answer answerq183 = new Answer( 3L,"La carte Dermalog fait problème");
        Answer answerq184 = new Answer( 4L,"Les partis politiques ne sont pas intéressés");
        Answer answerq185 = new Answer( 5L,"Les gens ne vont pas aux élections sous ce Président");
        Answer answerq186 = new Answer( 6L," Il est difficile de faire campagne");
        Answer answerq187 = new Answer( 7L," Le climat d’insécurité casse les velléités des candidats");
        Answer answerq188 = new Answer( 8L," On ne croit plus aux élections");
        Answer answerq1812 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1813 = new Answer( 66L, "Autre");
        Answer answerq1814 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq181);
        answerList.add(answerq182);
        answerList.add(answerq183);
        answerList.add(answerq184);
        answerList.add(answerq185);
        answerList.add(answerq186);
        answerList.add(answerq187);
        answerList.add(answerq188);
        answerList.add(answerq1812);
        answerList.add(answerq1813);
        answerList.add(answerq1814);
        question18.setAnswerList(answerList);
        questions.add(question18);



        //19
        answerList = new ArrayList<>();
        Question question19 = new Question( "Êtes-vous membre d’un parti politique ? ", false);
        Answer answerq191 = new Answer( 1L,"Oui");
        Answer answerq192 = new Answer( 2L,"Non");
        Answer answerq1912 = new Answer( 55L,"Je ne sais pas");
        Answer answerq1914 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq191);
        answerList.add(answerq192);
        answerList.add(answerq1912);
        answerList.add(answerq1914);
        question19.setAnswerList(answerList);
        questions.add(question19);

        //20
        answerList = new ArrayList<>();
        Question question20 = new Question( "(Si la réponse à la question 19 est non) Indiquez trois (3) raisons ", true);
        Answer answerq201 = new Answer( 1L,"Les partis sont trop nombreux");
        Answer answerq202 = new Answer( 2L,"Pas d’idéologie  ");
        Answer answerq203 = new Answer( 3L,"C’est d’abord une affaire de famille");
        Answer answerq204 = new Answer( 4L," Il est dangereux dans ce pays");
        Answer answerq205 = new Answer( 5L," Les partis ne sont pas suffisamment structurés");
        Answer answerq206 = new Answer( 6L,"Pas sûr que mon engagement servira à quelque chose");
        Answer answerq207 = new Answer( 7L," Une affaire de magouilleurs");
        Answer answerq208 = new Answer( 8L," J’ai peur du « qu’en dira-t-on ? »");
        Answer answerq2012 = new Answer( 55L,"Je ne sais pas");
        Answer answerq2013 = new Answer( 66L, "Autre");
        Answer answerq2014 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq201);
        answerList.add(answerq202);
        answerList.add(answerq203);
        answerList.add(answerq204);
        answerList.add(answerq205);
        answerList.add(answerq206);
        answerList.add(answerq207);
        answerList.add(answerq208);
        answerList.add(answerq2012);
        answerList.add(answerq2013);
        answerList.add(answerq2014);
        question20.setAnswerList(answerList);
        questions.add(question20);

        //21
        answerList = new ArrayList<>();
        Question question21 = new Question( "Étant donné la situation actuelle du pays, êtes-vous satisfait des Responsables du Pouvoir ?", false);
        Answer answerq211 = new Answer( 1L,"Très satisfait d’eux");
        Answer answerq212 = new Answer( 2L,"Satisfait  ");
        Answer answerq213 = new Answer( 3L,"Moyennement satisfait");
        Answer answerq214 = new Answer( 4L,"Peu satisfait");
        Answer answerq215 = new Answer( 5L," Pas satisfait");
        Answer answerq216 = new Answer( 6L,"Pas satisfait du tout");
        Answer answerq2112 = new Answer( 55L,"Je ne sais pas");
        Answer answerq2113 = new Answer( 66L, "Autre");
        Answer answerq2114 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq211);
        answerList.add(answerq212);
        answerList.add(answerq213);
        answerList.add(answerq214);
        answerList.add(answerq215);
        answerList.add(answerq216);
        answerList.add(answerq2112);
        answerList.add(answerq2113);
        answerList.add(answerq2114);
        question21.setAnswerList(answerList);
        questions.add(question21);


        //22
        answerList = new ArrayList<>();
        Question question22 = new Question( "Étant donné la situation actuelle du pays, êtes-vous satisfait des Responsables de l’Opposition ?", false);
        Answer answerq221 = new Answer( 1L,"Très satisfait d’eux");
        Answer answerq222 = new Answer( 2L,"Satisfait  ");
        Answer answerq223 = new Answer( 3L,"Moyennement satisfait");
        Answer answerq224 = new Answer( 4L,"Peu satisfait");
        Answer answerq225 = new Answer( 5L," Pas satisfait");
        Answer answerq226 = new Answer( 6L,"Pas satisfait du tout");
        Answer answerq2212 = new Answer( 55L,"Je ne sais pas");
        Answer answerq2213 = new Answer( 66L, "Autre");
        Answer answerq2214 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq221);
        answerList.add(answerq222);
        answerList.add(answerq223);
        answerList.add(answerq224);
        answerList.add(answerq225);
        answerList.add(answerq226);
        answerList.add(answerq2212);
        answerList.add(answerq2213);
        answerList.add(answerq2214);
        question22.setAnswerList(answerList);
        questions.add(question22);


        //23
        answerList = new ArrayList<>();
        Question question23 = new Question( "Étant donné la situation actuelle du pays, quelles seraient les pistes de sortie de crise ? (trois réponses)", true);
        Answer answerq231 = new Answer( 1L,"Des négociations honnêtes entre Haïtiens");
        Answer answerq232 = new Answer( 2L,"Le Président reste jusqu’au 7 février 2021  ");
        Answer answerq233 = new Answer( 3L,"Le Président reste jusqu’au 7 février 2022");
        Answer answerq234 = new Answer( 4L,"La mise en place d’un Pouvoir de transition au plus tôt");
        Answer answerq235 = new Answer( 5L,"La démission du Président");
        Answer answerq236 = new Answer( 6L,"Pas sûr que mon engagement servira à quelque chose");
        Answer answerq237 = new Answer( 7L,"Un sursis de l’Opposition au Pouvoir en place");
        Answer answerq238 = new Answer( 8L," Une énième ingérence de l’international");
        Answer answerq239 = new Answer( 9L," La politique de l’usure");
        Answer answerq2312 = new Answer( 55L,"Je ne sais pas");
        Answer answerq2313 = new Answer( 66L, "Autre");
        Answer answerq2314 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq231);
        answerList.add(answerq232);
        answerList.add(answerq233);
        answerList.add(answerq234);
        answerList.add(answerq235);
        answerList.add(answerq236);
        answerList.add(answerq237);
        answerList.add(answerq238);
        answerList.add(answerq239);
        answerList.add(answerq2312);
        answerList.add(answerq2313);
        answerList.add(answerq2314);
        question23.setAnswerList(answerList);
        questions.add(question23);


        //24
        answerList = new ArrayList<>();
        Question question24 = new Question( "Qu’est-ce qui selon vous expliquerait cette crise que vit le pays depuis 1804 ?", false);
        Answer answerq241 = new Answer( 1L,"Les Haïtiens sont assoiffés de pouvoir");
        Answer answerq242 = new Answer( 2L,"La culture de la division");
        Answer answerq243 = new Answer( 3L,"La haine de l’autre");
        Answer answerq244 = new Answer( 4L,"Trop de religions");
        Answer answerq245 = new Answer( 5L,"Trop de préjugés");
        Answer answerq246 = new Answer( 6L," L’amour excessif de l’argent");
        Answer answerq247 = new Answer( 7L,"Les bases sociales sont mauvaises");
        Answer answerq248 = new Answer( 8L,"Les Haïtiens n’aiment pas leur pays");
        Answer answerq249 = new Answer( 9L," Les mauvaises élections");
        Answer answerq2410 = new Answer( 10L,"L’égoïsme des Haïtiens");
        Answer answerq2412 = new Answer( 55L,"Je ne sais pas");
        Answer answerq2413 = new Answer( 66L, "Autre");
        Answer answerq2414 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq241);
        answerList.add(answerq242);
        answerList.add(answerq243);
        answerList.add(answerq244);
        answerList.add(answerq245);
        answerList.add(answerq246);
        answerList.add(answerq247);
        answerList.add(answerq248);
        answerList.add(answerq249);
        answerList.add(answerq2410);
        answerList.add(answerq2412);
        answerList.add(answerq2413);
        answerList.add(answerq2414);
        question24.setAnswerList(answerList);
        questions.add(question24);



        //24
        answerList = new ArrayList<>();
        Question question25 = new Question( "Selon vous qu’est-ce qui peut porter les Haïtiens à se mettre ensemble aujourd’hui ?", false);
        Answer answerq251 = new Answer( 1L,"Une conférence nationale");
        Answer answerq252 = new Answer( 2L,"La culture de la division");
        Answer answerq253 = new Answer( 3L,"Un pacte politique");
        Answer answerq254 = new Answer( 4L,"Un plan de développement intégré");
        Answer answerq255 = new Answer( 5L,"Une autre Constitution");
        Answer answerq256 = new Answer( 6L,"  Plus rien n’est possible");
        Answer answerq257 = new Answer( 7L,"Aucun");
        Answer answerq2512 = new Answer( 55L,"Je ne sais pas");
        Answer answerq2513 = new Answer( 66L, "Autre");
        Answer answerq2514 = new Answer( 99L,"Aucune réponse");

        answerList.add(answerq251);
        answerList.add(answerq252);
        answerList.add(answerq253);
        answerList.add(answerq254);
        answerList.add(answerq255);
        answerList.add(answerq256);
        answerList.add(answerq257);
        answerList.add(answerq2512);
        answerList.add(answerq2513);
        answerList.add(answerq2514);
        question25.setAnswerList(answerList);
        questions.add(question25);



    }

    public List<Question> getQuestions() {
        return questions;
    }
}
