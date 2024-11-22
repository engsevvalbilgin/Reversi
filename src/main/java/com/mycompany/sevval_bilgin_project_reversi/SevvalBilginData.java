/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sevval_bilgin_project_reversi;

//import static com.mycompany.sevval_bilgin_2221221013_bp2_project.SevvalBilginUsers.scores;
import static com.mycompany.sevval_bilgin_project_reversi.SevvalBilginLogInFrame.entered_users_list;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author hp
 */
public class SevvalBilginData {

    public static boolean isPlayed = false;

    public enum UserScoreStatus {
        UserAdded, UserUpdated
    }
    static ArrayList<SevvalBilginUsers> userList = new ArrayList<>();
    static ArrayList<SevvalBilginUsers> scoresList = new ArrayList<>();
    public static String user_txt_file_name = "userList.txt";
    public static String score_txt_file_name = "scoresList.txt";

    public static boolean Login(String name, String mail, String password) {
        boolean isLogin = false;
        for (SevvalBilginUsers s : userList) {
            if (s.name.compareTo(name) == 0 && s.mail.compareTo(mail) == 0 && s.password.compareTo(password) == 0) {
                isLogin = true;
//
                return isLogin;

            }

        }
        return isLogin;
    }

    public static void AddUserToUserList(SevvalBilginUsers user) throws Exception {

        userList.add(user);

    }
    public static UserScoreStatus stat;

    public static UserScoreStatus AddUserToScoresList(String name, int score) {

        for (SevvalBilginUsers s : scoresList) {
            if (s.name.compareTo(name) == 0) {
                s.score = score;
                return UserScoreStatus.UserUpdated;

            }
        }
        SevvalBilginUsers usr1 = new SevvalBilginUsers(name, score);
        scoresList.add(usr1);
        usr1.setName(name);
        usr1.setScore(score);
        return UserScoreStatus.UserAdded;
    }

    public static void WriteUserListToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(user_txt_file_name));
        for (SevvalBilginUsers s : userList) {
            String values = s.toString();
            writer.append(values + "\n");
        }
        writer.close();
    }

    public static void removeFromScoresFile(String name) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(score_txt_file_name));
        for (SevvalBilginUsers s : scoresList) {
            try ( BufferedReader reader = new BufferedReader(new FileReader(score_txt_file_name))) {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    if (line.contains(name)) {
                        continue;
                    } else {
                        String values = s.getScoreInfos();
                        writer.write(values + "\n");
                    }

                }
            }

        }
        writer.close();

    }

    public static void WriteScoreListToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(score_txt_file_name));
        for (SevvalBilginUsers s : scoresList) {
            String values = s.getScoreInfos();
            writer.append(values + "\n");
        }
        writer.close();
    }

    public static void ReadFromFileToUserList() throws IOException {
        try ( BufferedReader reader = new BufferedReader(new FileReader(user_txt_file_name))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("&");
                SevvalBilginUsers readUser = new SevvalBilginUsers();
                readUser.id = Integer.parseInt(values[0]);
                readUser.name = values[1];
                readUser.mail = values[2];
                readUser.phone = Integer.parseInt(values[3]);
                readUser.address = values[4];
                readUser.password = values[5];
                userList.add(readUser);

            }
        }

    }

    public static void ReadFromFileToScoreList() throws IOException {
        try ( BufferedReader reader = new BufferedReader(new FileReader(score_txt_file_name))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("&");
                SevvalBilginUsers readScoreUser = new SevvalBilginUsers();
                SevvalBilginScoresTable.tbl_scores_model.addRow(values);
                readScoreUser.name = values[0];
                readScoreUser.score = Integer.parseInt(values[1]);
                scoresList.add(readScoreUser);

            }
        }

    }
    static int a = -1;

    public static void checkStatus(SevvalBilginMyButton selected_button) {
        a++;

        if (a % 2 == 0) {
            SevvalBilginUsers.setPlayertoBlackUser();
        } else if (a % 2 == 1) {
            SevvalBilginUsers.setPlayertoWhiteUser();
        }
     
        String green = "java.awt.Color[r=0,g=255,b=0]";
        //oyuncu yeşil taşa tıkladıysa
        if (selected_button.getBackground().toString().compareTo(green) == 0) {
            //oynayan oyuncu siyah taşlara sahipse

            if (SevvalBilginUsers.getPlayer().getColor().compareTo(SevvalBilginUsers.ColorName.black) == 0) {
                // üst kontrol
                int cx = selected_button.getCx();
                int cy = selected_button.getCy();
                int nx;
                int ny;
                int gx = -1;
                int gy = 0;

                int state = 0;//8 yön
                while (state < 8) {
                    switch (state) {
                        case 0:
                            gx = 1;
                            gy = 0;
                            break;
                        case 1:
                            gx = 1;
                            gy = 1;
                            break;
                        case 2:
                            gx = 0;
                            gy = 1;
                            break;
                        case 3:
                            gx = -1;
                            gy = 1;
                            break;
                        case 4:
                            gx = -1;
                            gy = 0;
                            break;
                        case 5:
                            gx = -1;
                            gy = -1;
                            break;
                        case 6:
                            gx = 0;
                            gy = -1;
                            break;
                        case 7:
                            gx = 1;
                            gy = -1;
                            break;

                    }

                    nx = cx + gx;
                    ny = cy + gy;
                    ArrayList<SevvalBilginMyButton> blist = new ArrayList<>();
//tahtanın dışına çıkan durumları göz ardı et
                    while (((nx < SevvalBilginGameSceneFrame.count && nx > -1) && (ny < SevvalBilginGameSceneFrame.count && ny > -1))) {

                        if (SevvalBilginGameSceneFrame.buttonMatrix[nx][ny].type == 'g') {
                            break;
                        } else if (SevvalBilginGameSceneFrame.buttonMatrix[nx][ny].type == 'w') {
                            blist.add(SevvalBilginGameSceneFrame.buttonMatrix[nx][ny]);

                        } else if (SevvalBilginGameSceneFrame.buttonMatrix[nx][ny].type == 'b') {

                            for (SevvalBilginMyButton myButton : blist) {
                                selected_button.setColor(Color.black, 'b');
                                SevvalBilginLogInFrame.entered_users_list[1].updateScore(entered_users_list[1], 1);
//                                
                                myButton.setColor(Color.BLACK, 'b');
                                SevvalBilginGameSceneFrame.black_buttons++;
                                SevvalBilginLogInFrame.entered_users_list[1].updateScore(entered_users_list[1], 1);
//                                
                                SevvalBilginData.isPlayed = true;
                            }
                            break;

                        }

                        nx = nx + gx;
                        ny = ny + gy;

                    }

                    state++;

                }

            }//kullanıcı beyaz taşlara sahipse
            if (SevvalBilginUsers.getPlayer().getColor().compareTo(SevvalBilginUsers.ColorName.white) == 0) {

                int cx = selected_button.getCx();
                int cy = selected_button.getCy();
                int nx;
                int ny;
                int gx = 0;
                int gy = 0;
                int state = 0;//8 yön
                while (state < 8) {
                    switch (state) {
                        case 0:
                            gx = 1;
                            gy = 0;
                            break;
                        case 1:
                            gx = 1;
                            gy = 1;
                            break;
                        case 2:
                            gx = 0;
                            gy = 1;
                            break;
                        case 3:
                            gx = -1;
                            gy = 1;
                            break;
                        case 4:
                            gx = -1;
                            gy = 0;
                            break;
                        case 5:
                            gx = -1;
                            gy = -1;
                            break;
                        case 6:
                            gx = 0;
                            gy = -1;
                            break;
                        case 7:
                            gx = 1;
                            gy = -1;
                            break;

                    }

                    nx = cx + gx;
                    ny = cy + gy;
                    ArrayList<SevvalBilginMyButton> wlist = new ArrayList<>();
//tahtanındışını kontrolü engeller
                    while (((nx < SevvalBilginGameSceneFrame.count && nx > -1) && (ny < SevvalBilginGameSceneFrame.count && ny > -1))) {

                        if (SevvalBilginGameSceneFrame.buttonMatrix[nx][ny].type == 'g') {
                            break;
                        } else if (SevvalBilginGameSceneFrame.buttonMatrix[nx][ny].type == 'b') {

                            wlist.add(SevvalBilginGameSceneFrame.buttonMatrix[nx][ny]);

                        } else if (SevvalBilginGameSceneFrame.buttonMatrix[nx][ny].type == 'w') {

                            for (SevvalBilginMyButton myButton : wlist) {
                                selected_button.setColor(Color.white, 'w');
                                myButton.setColor(Color.white, 'w');
                                SevvalBilginGameSceneFrame.white_buttons++;
                                SevvalBilginLogInFrame.entered_users_list[0].updateScore(entered_users_list[0], 1);
                                SevvalBilginLogInFrame.entered_users_list[0].updateScore(entered_users_list[0], 1);
                                selected_button.setColor(Color.white, 'b');

//                                
                            }
                            break;

                        }
                        nx = nx + gx;
                        ny = ny + gy;

                    }

                    state++;

                }

            }

        } else {
            JOptionPane.showMessageDialog(selected_button, "It has a stone on ");
        }

    }
}


