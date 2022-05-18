package com.game.colorroll.viewmodJg;

import static com.game.colorroll.actJg.GameActivityJg.arrayList;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Display;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.game.colorroll.actJg.GameActivityJg;
import com.game.colorroll.actJg.StartActivityJG;
import com.game.colorroll.modJg.ButtonJG;
import com.game.colorroll.modJg.CreationElementJg;
import com.game.colorroll.modJg.FbSetEG;
import com.game.colorroll.modJg.FireJg;
import com.game.colorroll.modJg.MediaJG;
import com.game.colorroll.modJg.MoveProgJG;
import com.game.colorroll.modJg.MovesnackJC;
import com.game.colorroll.modJg.SaveJg;

import java.util.ArrayList;

public class ViewModJg extends AndroidViewModel {

    MovesnackJC movesnackJC;
    CreationElementJg creationElementJg;

    MediaJG mediaJG;
    SaveJg saveJg;
    ButtonJG buttonJG;
    MoveProgJG moveProgJG;
    FireJg fireJg;
    FbSetEG fbSetEG;

    public ViewModJg(@NonNull Application application) {
        super(application);

        saveJg = new SaveJg();
        buttonJG= new ButtonJG();
        moveProgJG = new MoveProgJG();
        fireJg = new FireJg();
        fbSetEG = new FbSetEG();
    }

    public String getSaveJ(){
       return saveJg.getSaveJg();
    }
    public void saveJ(String bb){
        saveJg.setSaveJg(bb);
    }
    public void  setFbSetEG(StartActivityJG startActivityJG){
        fbSetEG.fbSetEG(startActivityJG);
    }
    public FireJg fireJg(StartActivityJG startActivityJG){
        fireJg.fireJG(startActivityJG);
        return fireJg;
    }

    public void buttonIntJG(Button button,Activity activity){
        buttonJG.setActivity(activity);
        buttonJG.buttonInJG(button);
    }
    public void moveProgJG(ImageView image1,ImageView image2, ImageView image3,int w){
        moveProgJG.moveProJG(image1,image2,image3,w);
    }

    public void saveRecJG(String sss){
        saveJg.setSaveRecJG(sss);
    }

    public String getRecJG(){
        return saveJg.getSaveRecJG();
    }

    public void setButtonJG(Activity activity,Button buttonStJG, Button buttonRulJG, Button  buttonCloJG, Button buttonsettingsJG, Button buttonrecordJG){
        buttonJG.setActivity(activity);
        buttonJG.buttonJG(buttonStJG,buttonRulJG,buttonCloJG,buttonsettingsJG,buttonrecordJG,mediaJG,getSaveIntJG());
    }

    public void saveJg(Activity activity){
        saveJg.setGameActivityJg(activity);
    }

    public void saveIntJG(int a){
        saveJg.setSaveNumberJg(a);
    }

    public int getSaveIntJG(){
        return saveJg.getSaveNumberJg();
    }

    public void media(Context context){
        mediaJG = new MediaJG(context);
        mediaJG.mediaPlayCrateMg(getSaveIntJG());

    }

    public void stopMediaJG(){
        mediaJG.mediaPlayStopMG(getSaveIntJG());
    }

    public void mediaPlay1(Context context){
        mediaJG.mediaPlay1(context);
    }
    public void mediaPlay2(Context context){
        mediaJG.mediaPlay2(context);
    }
    public void mediaPlay3(Context context){
        mediaJG.mediaPlay3(context);
    }

    public void mediaStop1(){
        mediaJG.mediaStop1();
    }
    public void mediaStop2(){
        mediaJG.mediaStop2();
    }
    public void mediaStop3(){
        mediaJG.mediaStop3();
    }

    public void crElement(Display display, ImageView imageViewElem){
        creationElementJg = new CreationElementJg(display.getWidth(),display.getHeight(),imageViewElem);
        creationElementJg.createElementJg();
        creationElementJg.randomImageJG();
    }

    public void gg(){
        movesnackJC.setSt(true);
    }

    public void jgj(ImageView imageView){

        arrayList.add(imageView);
        movesnackJC.setArrayListJg(arrayList);
    }

    public void moveJk(Display display, ImageView imgSnake) {
        movesnackJC = new MovesnackJC(display.getWidth(), display.getHeight(), imgSnake);
        movesnackJC.moveJGR(getSaveIntJG());
        movesnackJC.setMediaJG(mediaJG);
    }

    public void visibleJg(TextView textViewGO,TextView textViewRE){
        movesnackJC.setTextViewGO(textViewGO);
        movesnackJC.setTextViewRE(textViewRE);
    }

    public void moveR() {
        if (!movesnackJC.isL()) {
            movesnackJC.setR(true);
            movesnackJC.setL(false);
            movesnackJC.setT(false);
            movesnackJC.setB(false);
            movesnackJC.moveJGR(getSaveIntJG());
        }
    }

    public void moveL() {
        if (!movesnackJC.isR()) {
            movesnackJC.setR(false);
            movesnackJC.setL(true);
            movesnackJC.setT(false);
            movesnackJC.setB(false);
            movesnackJC.moveJGL(getSaveIntJG());
        }

    }

    public void moveT() {
        if (!movesnackJC.isB()) {
            movesnackJC.setR(false);
            movesnackJC.setL(false);
            movesnackJC.setT(true);
            movesnackJC.setB(false);
            movesnackJC.moveJGT(getSaveIntJG());
        }
    }

    public void moveB() {
        if (!movesnackJC.isT()) {
            movesnackJC.setR(false);
            movesnackJC.setL(false);
            movesnackJC.setT(false);
            movesnackJC.setB(true);
            movesnackJC.moveJGB(getSaveIntJG());
        }
    }
}
