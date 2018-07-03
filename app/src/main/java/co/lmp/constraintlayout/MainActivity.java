package co.lmp.constraintlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

/**
 * Created by lin min phyo on 7/1/18.
 */
public class MainActivity extends AppCompatActivity {

  ConstraintLayout constraintLayout;

  ConstraintSet constraintSetInitial;
  ConstraintSet constraintSetExpanded;

  boolean isExpanded = false;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_dog);
    constraintLayout = findViewById(R.id.constraint_initial);

    constraintSetInitial = new ConstraintSet();
    constraintSetInitial.clone(this, R.layout.layout_dog);

    constraintSetExpanded = new ConstraintSet();
    constraintSetExpanded.clone(this, R.layout.layout_dog_expanded);

    findViewById(R.id.btnBuy).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        if (isExpanded) {
          constraintSetInitial.applyTo(constraintLayout);
        } else {
          constraintSetExpanded.applyTo(constraintLayout);
        }

        isExpanded = !isExpanded;
      }
    });
  }
}
