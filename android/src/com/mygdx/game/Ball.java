package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;


public class Ball {

    int x;
    int y;
    int xSpeed;
    int ySpeed;
    int size;
    Color color = Color.GREEN;


    public Ball(int x,  int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

    }
    public void update(){
        x+= xSpeed;
        if (x < 50|| x > (Gdx.graphics.getWidth() - this.size )){
            xSpeed = -xSpeed;
        }
        y+= ySpeed;
        if (y > (Gdx.graphics.getHeight() - this.size )){
            ySpeed = -ySpeed;
        }

    }
    public void draw(ShapeRenderer shape){
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    Random r = new Random();
    int minRandomX = 20;
    int maxRandomX = 1;
    int minRandomY = -20;
    int maxRandomY = -1;
    public void checkCollision(Paddle paddle){
        if (collidesWith(paddle)){

            ySpeed = -ySpeed;
            if (xSpeed >= 1){
                xSpeed = r.nextInt((minRandomX - maxRandomX) + minRandomX) ;
            }
            if (xSpeed  == - xSpeed){
                xSpeed = (r.nextInt (minRandomY + maxRandomY) - maxRandomY);
            }
        }
    }
    public void checkCollision(Block block){
        if (collidesWith(block)){
            ySpeed = -ySpeed;
            block.setDestroyed(true);

        }
    }


    private boolean collidesWith(Paddle paddle){
        // collision between paddle and ball

        double dx=Math.abs(this.x-(paddle.x+paddle.width/2));
        double dy=Math.abs(this.y-(paddle.y+paddle.height/2));

        if( dx > this.size+paddle.width/2 ){ return(false); }
        if( dy > this.size+paddle.height/2 ){ return(false); }

        if( dx <= paddle.width ){ return(true); }
        if( dy <= paddle.height ){ return(true); }

         dx= dx-paddle.width;
         dy= dy-paddle.height;
        return(dx*dx+dy*dy<=this.size*this.size);
    }

    private boolean collidesWith(Block block){
        // collision between paddle and ball

        double dx=Math.abs(this.x-(block.x+block.width/2));
        double dy=Math.abs(this.y-(block.y+block.height/2));

        if( dx > this.size+block.width/2 ){ return(false); }
        if( dy > this.size+block.height/2 ){ return(false); }

        if( dx <= block.width ){ return(true); }
        if( dy <= block.height ){ return(true); }

        dx= dx-block.width;
        dy= dy-block.height;
        return(dx*dx+dy*dy<=this.size*this.size);

    }
}
