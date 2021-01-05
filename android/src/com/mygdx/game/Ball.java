package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;


public class Ball {

    int x;
    int y;
    int xSpeed;
    int ySpeed;
    int size;
    Color color = Color.WHITE;


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
        if ( y > (Gdx.graphics.getHeight() - this.size )){
            ySpeed = -ySpeed;
        }

    }
    public void draw(ShapeRenderer shape){
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle){
        if (collidesWith(paddle)){
            color= Color.WHITE;
            ySpeed = -ySpeed;
        } else {
            color = Color.BROWN;
        }
    }

    private boolean collidesWith(Paddle paddle){
        // collision between paddle and ball

        double dx=Math.abs(this.x-(paddle.x+paddle.widht/2));
        double dy=Math.abs(this.y-(paddle.y+paddle.height/2));

        if( dx > this.size+paddle.widht/2 ){ return(false); }
        if( dy > this.size+paddle.height/2 ){ return(false); }

        if( dx <= paddle.widht ){ return(true); }
        if( dy <= paddle.height ){ return(true); }

         dx= dx-paddle.widht;
         dy= dy-paddle.height;
        return(dx*dx+dy*dy<=this.size*this.size);


    }
}
