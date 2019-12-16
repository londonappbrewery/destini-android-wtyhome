package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView txtStoryText;
    Button btnTop;
    Button btnDown;
    int currentStoryIndex=0;
    StoryClass storys[]={
            new StoryClass(R.string.T1_Story,R.string.T1_Ans1,R.string.T1_Ans2,2,1),
            new StoryClass(R.string.T2_Story,R.string.T2_Ans1,R.string.T2_Ans2,5,4),
            new StoryClass(R.string.T3_Story,R.string.T3_Ans1,R.string.T3_Ans2,5,4),
            new StoryClass(R.string.T4_End,-1,-1,-1,-1),
            new StoryClass(R.string.T5_End,-1,-1,-1,-1),
            new StoryClass(R.string.T6_End,-1,-1,-1,-1),
    };
    private void UpdateResult(boolean isGoTop)
    {
        //取得路徑ID並將目前currentStoryIndex改寫為該id
        if(isGoTop)
        {
            currentStoryIndex=storys[currentStoryIndex].getTopPath();
        }
        else
        {
            currentStoryIndex=storys[currentStoryIndex].getDownPath();
        }


        //更新敘述文字，並視情況更改按鈕外觀
        StoryClass story=storys[currentStoryIndex];

        Log.d("[STORY]",String.format("Story Index:%d\nTop Path:%d\nDown Path:%d",currentStoryIndex,story.getTopPath(),story.getDownPath()));
        txtStoryText.setText(story.getStoryTextID());

        if(story.getTopAnswerID()!=-1)
        {
            //如果還有上路可走，則顯示並取代目前按鈕文字
            btnTop.setEnabled(true);
            btnTop.setText(story.getTopAnswerID());
        }
        else
        {
            //無路可走，則不顯示
            btnTop.setEnabled(false);
            btnTop.setVisibility(View.INVISIBLE);
        }

        if(story.getDownAnswerID()!=-1)
        {
            //如果還有下路可走，則顯示並取代目前按鈕文字
            btnDown.setEnabled(true);
            btnDown.setText(story.getDownAnswerID());
        }
        else
        {
            //無路可走，則不顯示
            btnDown.setEnabled(false);
            btnDown.setVisibility(View.INVISIBLE);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        txtStoryText=findViewById(R.id.storyTextView);
        btnTop=findViewById(R.id.buttonTop);
        btnDown=findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateResult(true);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateResult(false);
            }
        });

    }
}
