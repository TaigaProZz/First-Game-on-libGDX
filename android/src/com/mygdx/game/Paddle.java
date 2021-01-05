package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int widht;
    int height;

    public Paddle(int x, int y, int widht, int height){
        this.x = x;
        this.y = y;
        this.widht = widht;
        this.height = height;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(Gdx.input.getX(), this.y, widht, height);
        this.x = Gdx.input.getX();


    }
}
