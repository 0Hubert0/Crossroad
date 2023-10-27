package com.example;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    static Canvas canvas = new Canvas(900, 600);
    static GraphicsContext gr = canvas.getGraphicsContext2D();
    static boolean light1 = true, light2 = true, light3 = false, light4 = false, change1=false, change2=false;
    static Lane[] lanes;
    static double maxSpeed = 2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root, 900, 600);
        root.getChildren().add(canvas);



        gr.setFill(Color.BEIGE);
        gr.setLineWidth(3);
        gr.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gr.setFill(Color.BLACK);
        gr.fillRect(400, 0, 200, canvas.getHeight());
        gr.fillRect(0, 300, canvas.getWidth(), 100);
        gr.setStroke(Color.BEIGE);
        gr.strokeRect(398, 298, 203, 103);
        gr.setLineWidth(1);
        gr.strokeRect(498, 0, 4, 298);
        gr.strokeRect(498, 400, 4, 200);
        gr.strokeRect(0, 348, 398, 4);
        gr.strokeRect(602, 348, 298, 4);
        gr.setLineDashes(10);
        gr.strokeRect(-2, 325, 399, 50);
        gr.strokeRect(601, 325, 300, 50);
        gr.strokeRect(433, -2, 33, 300);
        gr.strokeRect(534, -2, 33, 300);
        gr.strokeRect(433, 400, 33, 203);
        gr.strokeRect(534, 400, 33, 203);
        gr.setLineDashes(0);
        gr.fillRect(360, 230, 30, 60);
        gr.fillRect(610, 410, 30, 60);
        gr.fillRect(330, 410, 60, 30);
        gr.fillRect(610, 260, 60, 30);
        gr.setFill(Color.LIMEGREEN);
        gr.fillOval(364, 234, 22, 22);
        gr.fillOval(614, 444, 22, 22);
        gr.fillOval(334, 414, 22, 22);
        gr.fillOval(644, 264, 22, 22);
        gr.setFill(Color.RED);
        gr.fillOval(364, 264, 22, 22);
        gr.fillOval(614, 414, 22, 22);
        gr.fillOval(364, 414, 22, 22);
        gr.fillOval(614, 264, 22, 22);



        scene.setOnMouseClicked(event -> {
            if (event.getX() > 360 && event.getX() < 390 && event.getY() > 230 && event.getY() < 290) {
                light1 = !light1;
            } else if (event.getX() > 610 && event.getX() < 640 && event.getY() > 410 && event.getY() < 470) {
                light2 = !light2;
            } else if (event.getX() > 330 && event.getX() < 410 && event.getY() > 390 && event.getY() < 440) {
                light3 = !light3;
            } else if (event.getX() > 610 && event.getX() < 670 && event.getY() > 260 && event.getY() < 290) {
                light4 = !light4;
            }
        });

        scene.setOnMouseMoved(event -> {
            if (event.getX() > 360 && event.getX() < 390 && event.getY() > 230 && event.getY() < 290) {
                root.setCursor(Cursor.HAND);
            } else if (event.getX() > 610 && event.getX() < 640 && event.getY() > 410 && event.getY() < 470) {
                root.setCursor(Cursor.HAND);
            } else if (event.getX() > 330 && event.getX() < 410 && event.getY() > 390 && event.getY() < 440) {
                root.setCursor(Cursor.HAND);
            } else if (event.getX() > 610 && event.getX() < 670 && event.getY() > 260 && event.getY() < 290) {
                root.setCursor(Cursor.HAND);
            } else root.setCursor(Cursor.DEFAULT);
        });

        Lane north1 = new Lane(1, 577, 0);
        Lane north2 = new Lane(1, 544, 0);
        Lane north3 = new Lane(1, 511, 0);
        Lane south1 = new Lane(2, 475, 0);
        Lane south2 = new Lane(2, 442, 0);
        Lane south3 = new Lane(2, 409, 0);
        Lane east1 = new Lane(4, 0, 330);
        Lane east2 = new Lane(4, 0, 305);
        Lane west1 = new Lane(3, 0, 382);
        Lane west2 = new Lane(3, 0, 357);
        lanes = new Lane[]{north1, north2, north3, south1, south2, south3, east1, east2, west1, west2};

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gr.setFill(Color.BEIGE);
            gr.setLineWidth(3);
            gr.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gr.setFill(Color.BLACK);
            gr.fillRect(400, 0, 200, canvas.getHeight());
            gr.fillRect(0, 300, canvas.getWidth(), 100);
            gr.setStroke(Color.BEIGE);
            gr.strokeRect(398, 298, 203, 103);
            gr.setLineWidth(1);
            gr.strokeRect(498, 0, 4, 298);
            gr.strokeRect(498, 400, 4, 200);
            gr.strokeRect(0, 348, 398, 4);
            gr.strokeRect(602, 348, 298, 4);
            gr.setLineDashes(10);
            gr.strokeRect(-2, 325, 399, 50);
            gr.strokeRect(601, 325, 300, 50);
            gr.strokeRect(433, -2, 33, 300);
            gr.strokeRect(534, -2, 33, 300);
            gr.strokeRect(433, 400, 33, 203);
            gr.strokeRect(534, 400, 33, 203);
            gr.setLineDashes(0);
            gr.fillRect(360, 230, 30, 60);
            gr.fillRect(610, 410, 30, 60);
            gr.fillRect(330, 410, 60, 30);
            gr.fillRect(610, 260, 60, 30);
            if (light1) {
                gr.setFill(Color.LIMEGREEN);
                gr.fillOval(364, 234, 22, 22);
                gr.setFill(Color.DARKRED);
            } else {
                gr.setFill(Color.DARKGREEN);
                gr.fillOval(364, 234, 22, 22);
                gr.setFill(Color.RED);
            }
            gr.fillOval(364, 264, 22, 22);
            if (light2) {
                gr.setFill(Color.LIMEGREEN);
                gr.fillOval(614, 444, 22, 22);
                gr.setFill(Color.DARKRED);
            } else {
                gr.setFill(Color.DARKGREEN);
                gr.fillOval(614, 444, 22, 22);
                gr.setFill(Color.RED);
            }
            gr.fillOval(614, 414, 22, 22);
            if (light3) {
                gr.setFill(Color.LIMEGREEN);
                gr.fillOval(334, 414, 22, 22);
                gr.setFill(Color.DARKRED);
            } else {
                gr.setFill(Color.DARKGREEN);
                gr.fillOval(334, 414, 22, 22);
                gr.setFill(Color.RED);
            }
            gr.fillOval(364, 414, 22, 22);
            if (light4) {
                gr.setFill(Color.LIMEGREEN);
                gr.fillOval(644, 264, 22, 22);
                gr.setFill(Color.DARKRED);
            } else {
                gr.setFill(Color.DARKGREEN);
                gr.fillOval(644, 264, 22, 22);
                gr.setFill(Color.RED);
            }
            gr.fillOval(614, 264, 22, 22);
            for (int i = 0; i < 10; i++) {
                if (lanes[i].getCars().isEmpty()) {
                    lanes[i].add();
                } else {
                    switch (lanes[i].getDirection()) {
                        case 1:
                            if (lanes[i].getCars().get(lanes[i].getCars().size() - 1).getY() < canvas.getHeight() - 60) {
                                lanes[i].add();
                            }
                            for (int j = 0; j < lanes[i].getCars().size(); j++) {
                                if((light2 || lanes[i].getCars().get(j).getY()<400 ||
                                        (j!=0 && lanes[i].getCars().get(j).getY()-lanes[i].getCars().get(j-1).getY()>60 &&
                                        lanes[i].getCars().get(j-1).getY()>400) || (j==0 && lanes[i].getCars().get(j).getY()>430)
                                        || (j!=0 && ((lanes[i].getCars().get(j - 1).getY()<400 && lanes[i].getCars().get(j).getY()>430)
                                        || lanes[i].getCars().get(j).getY()-lanes[i].getCars().get(j - 1).getY()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*5)))
                                        && (j == 0 || lanes[i].getCars().get(j - 1).getY()<400
                                        || (lanes[i].getCars().get(j - 1).getV() < lanes[i].getCars().get(j).getV()) &&
                                        (lanes[i].getCars().get(j).getY()-lanes[i].getCars().get(j - 1).getY()>60))) {
                                    if (lanes[i].getCars().get(j).getV() > -maxSpeed) {
                                        lanes[i].getCars().get(j).decelerate();
                                        if (lanes[i].getCars().get(j).getV() < -maxSpeed) {
                                            lanes[i].getCars().get(j).setV(-maxSpeed);
                                        }
                                        if(j!=0 && (lanes[i].getCars().get(j).getV() < lanes[i].getCars().get(j-1).getV()))
                                        {
                                            lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                        }
                                    }
                                }
                                if(j!=0 && lanes[i].getCars().get(j-1).getV()>lanes[i].getCars().get(j).getV() &&
                                        lanes[i].getCars().get(j).getY()-lanes[i].getCars().get(j-1).getY()<1/lanes[i].getCars().get(j).getChangeOfVelocity()*4 &&
                                        lanes[i].getCars().get(j-1).getY()>400)
                                {
                                    lanes[i].getCars().get(j).accelerate();
                                    if(lanes[i].getCars().get(j).getV() > lanes[i].getCars().get(j-1).getV())
                                    {
                                        lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                    }
                                }
                                if(!light2 && lanes[i].getCars().get(j).getV()<0 && ((lanes[i].getCars().get(j).getY()-430<(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7 &&
                                        lanes[i].getCars().get(j).getY()>400 && (j==0 || lanes[i].getCars().get(j-1).getY()<415))
                                        || (j==0  && lanes[i].getCars().get(j).getY() < 430)  || (j!=0 && lanes[i].getCars().get(j-1).getY() > 400 && lanes[i].getCars().get(j-1).getV()==0 &&
                                        lanes[i].getCars().get(j).getY()-lanes[i].getCars().get(j-1).getY()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7)))
                                {
                                    lanes[i].getCars().get(j).accelerate();
                                    if(lanes[i].getCars().get(j).getV() > 0)
                                    {
                                        lanes[i].getCars().get(j).setV(0);
                                    }
                                }
                                lanes[i].getCars().get(j).setY(lanes[i].getCars().get(j).getY() + lanes[i].getCars().get(j).getV());
                                gr.setFill(lanes[i].getCars().get(j).getColor());
                                gr.fillRect(lanes[i].getX(), lanes[i].getCars().get(j).getY(),
                                        lanes[i].getCars().get(j).getWidth(), lanes[i].getCars().get(j).getHeight());
                                if (lanes[i].getCars().get(j).getY() < -40) {
                                    lanes[i].remove();
                                }
                            }
                            break;
                        case 2:
                            if (lanes[i].getCars().get(lanes[i].getCars().size() - 1).getY() > 60) {
                                lanes[i].add();
                            }

                            for (int j = 0; j < lanes[i].getCars().size(); j++) {
                                if((light1 || lanes[i].getCars().get(j).getY()>270 ||
                                        (j!=0 && lanes[i].getCars().get(j-1).getY()-lanes[i].getCars().get(j).getY()>60 &&
                                                lanes[i].getCars().get(j-1).getY()<270) || (j==0 && lanes[i].getCars().get(j).getY()<240)
                                        || (j!=0 && ((lanes[i].getCars().get(j - 1).getY()>270 && lanes[i].getCars().get(j).getY()<240)
                                        || lanes[i].getCars().get(j-1).getY()-lanes[i].getCars().get(j).getY()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*5)))
                                        && (j == 0 || lanes[i].getCars().get(j - 1).getY()>270
                                        || (lanes[i].getCars().get(j - 1).getV() > lanes[i].getCars().get(j).getV()) &&
                                        (lanes[i].getCars().get(j-1).getY()-lanes[i].getCars().get(j).getY()>60))) {
                                    if (lanes[i].getCars().get(j).getV() < maxSpeed) {
                                        lanes[i].getCars().get(j).accelerate();
                                        if (lanes[i].getCars().get(j).getV() > maxSpeed) {
                                            lanes[i].getCars().get(j).setV(maxSpeed);
                                        }
                                        if(j!=0 && (lanes[i].getCars().get(j).getV() > lanes[i].getCars().get(j-1).getV()))
                                        {
                                            lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                        }
                                    }
                                }
                                if(j!=0 && lanes[i].getCars().get(j-1).getV()<lanes[i].getCars().get(j).getV() &&
                                        lanes[i].getCars().get(j-1).getY()-lanes[i].getCars().get(j).getY()<1/lanes[i].getCars().get(j).getChangeOfVelocity()*4 &&
                                        lanes[i].getCars().get(j-1).getY()<270)
                                {
                                    lanes[i].getCars().get(j).decelerate();
                                    if(lanes[i].getCars().get(j).getV() < lanes[i].getCars().get(j-1).getV())
                                    {
                                        lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                    }
                                }
                                if(!light1 && lanes[i].getCars().get(j).getV()>0 && ((240-lanes[i].getCars().get(j).getY()<(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7 &&
                                        lanes[i].getCars().get(j).getY()<270 && (j==0 || lanes[i].getCars().get(j-1).getY()>255))
                                        || (j==0  && lanes[i].getCars().get(j).getY() > 240)  || (j!=0 && lanes[i].getCars().get(j-1).getY() < 270 && lanes[i].getCars().get(j-1).getV()==0 &&
                                        lanes[i].getCars().get(j-1).getY()-lanes[i].getCars().get(j).getY()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7)))
                                {
                                    lanes[i].getCars().get(j).decelerate();
                                    if(lanes[i].getCars().get(j).getV() < 0)
                                    {
                                        lanes[i].getCars().get(j).setV(0);
                                    }
                                }
                                lanes[i].getCars().get(j).setY(lanes[i].getCars().get(j).getY() + lanes[i].getCars().get(j).getV());
                                gr.setFill(lanes[i].getCars().get(j).getColor());
                                gr.fillRect(lanes[i].getX(), lanes[i].getCars().get(j).getY(),
                                        lanes[i].getCars().get(j).getWidth(), lanes[i].getCars().get(j).getHeight());

                            if (lanes[i].getCars().get(j).getY() > canvas.getHeight() + 5) {
                                lanes[i].remove();
                            }
                    }
                    break;
                    case 3:
                        if (lanes[i].getCars().get(lanes[i].getCars().size() - 1).getX() > 60) {
                            lanes[i].add();
                        }
                        for (int j = 0; j < lanes[i].getCars().size(); j++) {
                            if((light3 || lanes[i].getCars().get(j).getX()>370 ||
                                    (j!=0 && lanes[i].getCars().get(j-1).getX()-lanes[i].getCars().get(j).getX()>60 &&
                                            lanes[i].getCars().get(j-1).getX()<370) || (j==0 && lanes[i].getCars().get(j).getX()<340)
                                    || (j!=0 && ((lanes[i].getCars().get(j - 1).getX()>370 && lanes[i].getCars().get(j).getX()<340)
                                    || lanes[i].getCars().get(j-1).getX()-lanes[i].getCars().get(j).getX()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*5)))
                                    && (j == 0 || lanes[i].getCars().get(j - 1).getX()>370
                                    || (lanes[i].getCars().get(j - 1).getV() > lanes[i].getCars().get(j).getV()) &&
                                    (lanes[i].getCars().get(j-1).getX()-lanes[i].getCars().get(j).getX()>60))) {
                                if (lanes[i].getCars().get(j).getV() < maxSpeed) {
                                    lanes[i].getCars().get(j).accelerate();
                                    if (lanes[i].getCars().get(j).getV() > maxSpeed) {
                                        lanes[i].getCars().get(j).setV(maxSpeed);
                                    }
                                    if(j!=0 && (lanes[i].getCars().get(j).getV() > lanes[i].getCars().get(j-1).getV()))
                                    {
                                        lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                    }
                                }
                            }
                            if(j!=0 && lanes[i].getCars().get(j-1).getV()<lanes[i].getCars().get(j).getV() &&
                                    lanes[i].getCars().get(j-1).getX()-lanes[i].getCars().get(j).getX()<1/lanes[i].getCars().get(j).getChangeOfVelocity()*4 &&
                                    lanes[i].getCars().get(j-1).getX()<370)
                            {
                                lanes[i].getCars().get(j).decelerate();
                                if(lanes[i].getCars().get(j).getV() < lanes[i].getCars().get(j-1).getV())
                                {
                                    lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                }
                            }
                            if(!light3 && lanes[i].getCars().get(j).getV()>0 && ((340-lanes[i].getCars().get(j).getX()<(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7 &&
                                    lanes[i].getCars().get(j).getX()<370 && (j==0 || lanes[i].getCars().get(j-1).getX()>355))
                                    || (j==0  && lanes[i].getCars().get(j).getX() > 340)  || (j!=0 && lanes[i].getCars().get(j-1).getX() < 370 && lanes[i].getCars().get(j-1).getV()==0 &&
                                    lanes[i].getCars().get(j-1).getX()-lanes[i].getCars().get(j).getX()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7)))
                            {
                                lanes[i].getCars().get(j).decelerate();
                                if(lanes[i].getCars().get(j).getV() < 0)
                                {
                                    lanes[i].getCars().get(j).setV(0);
                                }
                            }
                            lanes[i].getCars().get(j).setX(lanes[i].getCars().get(j).getX() + lanes[i].getCars().get(j).getV());
                            gr.setFill(lanes[i].getCars().get(j).getColor());
                            gr.fillRect(lanes[i].getCars().get(j).getX(), lanes[i].getY(),
                                    lanes[i].getCars().get(j).getWidth(), lanes[i].getCars().get(j).getHeight());

                            if (lanes[i].getCars().get(j).getX() > canvas.getWidth() + 5) {
                                lanes[i].remove();
                            }
                        }
                        break;
                    case 4:
                        if (lanes[i].getCars().get(lanes[i].getCars().size() - 1).getX() < canvas.getWidth() - 60) {
                            lanes[i].add();
                        }
                        for (int j = 0; j < lanes[i].getCars().size(); j++) {
                            if((light4 || lanes[i].getCars().get(j).getX()<600 ||
                                    (j!=0 && lanes[i].getCars().get(j).getX()-lanes[i].getCars().get(j-1).getX()>60 &&
                                            lanes[i].getCars().get(j-1).getX()>600) || (j==0 && lanes[i].getCars().get(j).getX()>630)
                                    || (j!=0 && ((lanes[i].getCars().get(j - 1).getX()<600 && lanes[i].getCars().get(j).getX()>630)
                                    || lanes[i].getCars().get(j).getX()-lanes[i].getCars().get(j-1).getX()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*5)))
                                    && (j == 0 || lanes[i].getCars().get(j - 1).getX()<600
                                    || (lanes[i].getCars().get(j - 1).getV() < lanes[i].getCars().get(j).getV()) &&
                                    (lanes[i].getCars().get(j).getX()-lanes[i].getCars().get(j-1).getX()>60))) {
                                if (lanes[i].getCars().get(j).getV() > -maxSpeed) {
                                    lanes[i].getCars().get(j).decelerate();
                                    if (lanes[i].getCars().get(j).getV() < -maxSpeed) {
                                        lanes[i].getCars().get(j).setV(-maxSpeed);
                                    }
                                    if(j!=0 && (lanes[i].getCars().get(j).getV() < lanes[i].getCars().get(j-1).getV()))
                                    {
                                        lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                    }
                                }
                            }
                            if(j!=0 && lanes[i].getCars().get(j-1).getV()>lanes[i].getCars().get(j).getV() &&
                                    lanes[i].getCars().get(j).getX()-lanes[i].getCars().get(j-1).getX()<1/lanes[i].getCars().get(j).getChangeOfVelocity()*4 &&
                                    lanes[i].getCars().get(j-1).getX()>600)
                            {
                                lanes[i].getCars().get(j).accelerate();
                                if(lanes[i].getCars().get(j).getV() > lanes[i].getCars().get(j-1).getV())
                                {
                                    lanes[i].getCars().get(j).setV(lanes[i].getCars().get(j-1).getV());
                                }
                            }
                            if(!light4 && lanes[i].getCars().get(j).getV()<0 && ((lanes[i].getCars().get(j).getX()-630<(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7 &&
                                    lanes[i].getCars().get(j).getX()>600 && (j==0 || lanes[i].getCars().get(j-1).getX()<615))
                                    || (j==0  && lanes[i].getCars().get(j).getX() < 630)  || (j!=0 && lanes[i].getCars().get(j-1).getX() > 600 && lanes[i].getCars().get(j-1).getV()==0 &&
                                    lanes[i].getCars().get(j).getX()-lanes[i].getCars().get(j-1).getX()<30+(1/lanes[i].getCars().get(j).getChangeOfVelocity())*7)))
                            {
                                lanes[i].getCars().get(j).accelerate();
                                if(lanes[i].getCars().get(j).getV() > 0)
                                {
                                    lanes[i].getCars().get(j).setV(0);
                                }
                            }
                            lanes[i].getCars().get(j).setX(lanes[i].getCars().get(j).getX() + lanes[i].getCars().get(j).getV());
                            gr.setFill(lanes[i].getCars().get(j).getColor());
                            gr.fillRect(lanes[i].getCars().get(j).getX(), lanes[i].getY(),
                                    lanes[i].getCars().get(j).getWidth(), lanes[i].getCars().get(j).getHeight());

                            if (lanes[i].getCars().get(j).getX() < -45) {
                                lanes[i].remove();
                            }
                        }
                        break;
                }
            }
        }
    }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(5000), event -> {
            change1=false;
            change2=false;
            if(light1) {
                light1 = false;
                light2 = false;
                change1=true;
            }
            else{
                light3 = false;
                light4 = false;
                change2=true;
            }
        }),
                new KeyFrame(Duration.millis(7000), event -> {
                    if(change2) {
                        light1 = true;
                        light2 = true;
                    }
                    else{
                        light3 = true;
                        light4 = true;
                    }
                }));

        timeline1.setCycleCount(Animation.INDEFINITE);
        timeline1.play();

    Stage stage = new Stage();
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
}


    public static void main(String[] args) {
        launch(args);
    }
}
