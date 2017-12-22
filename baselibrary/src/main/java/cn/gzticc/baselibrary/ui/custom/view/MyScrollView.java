package cn.gzticc.baselibrary.ui.custom.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 *
 * @author pin
 *
 */
public class MyScrollView extends ScrollView {

	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public MyScrollView(Context context) { 
        super(context); 
    } 

    public MyScrollView(Context context, AttributeSet attrs, int defStyle) { 
        super(context, attrs, defStyle); 
    } 
    
    @Override  
    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {  
    	return 0;//禁止scrollView内布局变化后自动滚动 ��
    }  

}
