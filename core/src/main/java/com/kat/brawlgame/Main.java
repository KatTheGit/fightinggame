package com.kat.brawlgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture image;
    ExtendViewport viewport;

    Vector2 top_left_pos = new Vector2(0f, 0f);
    Vector2 top_right_pos = new Vector2(0f, 0f);
    Vector2 bot_left_pos = new Vector2(0f, 0f);
    Vector2 bot_right_pos = new Vector2(0f, 0f);


    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        viewport = new ExtendViewport(600f, 600f);
    }

    @Override
    public void render() {

        float delta = Gdx.graphics.getDeltaTime();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        viewport.getCamera().position.x = 0f;

        top_left_pos = new Vector2(-viewport.getWorldWidth() / 2.0f, viewport.getWorldHeight() / 2.0f);
        bot_left_pos = new Vector2(-viewport.getWorldWidth() / 2.0f, -viewport.getWorldHeight() / 2.0f);
        top_right_pos = new Vector2(viewport.getWorldWidth() / 2.0f, viewport.getWorldHeight() / 2.0f);
        bot_right_pos = new Vector2(viewport.getWorldWidth() / 2.0f, -viewport.getWorldHeight() / 2.0f);

        
        batch.begin();
        //batch.draw(image, top_left_pos.x, top_left_pos.y - 50f, 100f, 100f);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height, false);
    }
}
