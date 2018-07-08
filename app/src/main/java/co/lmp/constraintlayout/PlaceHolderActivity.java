package co.lmp.constraintlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

/**
 * Created by lin min phyo on 7/7/18.
 */
public class PlaceHolderActivity extends AppCompatActivity {

  Placeholder placeholder;

  ConstraintLayout root;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_placeholder);

    root = findViewById(R.id.root);
    placeholder = findViewById(R.id.placeholder);
  }

  public void swap(View view) {
    TransitionManager.beginDelayedTransition(root);
    placeholder.setContentId(view.getId());
  }
}
