GenericAdapter

针对RecyclerView而写的一个通用性Adapter，目的就是为了代码简洁和直观

Usage

第一步：
  
创建不同的类型布局

public class ItemHolderOne extend DataHolder{

  public TextItemHolder(Object data, int type) {
        super(data, type);
    }

    @Override
    public GenericViewHolder onCreateView(Context context) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_one,null);
        SimpleDraweeView ivIcon = .....;
        TextView tvName = .....;
        GenericViewHolder holder = new GenericViewHolder(item,ivIcon,tvName);
        return holder;
    }

    @Override
    public void onBindView(final Context context, GenericViewHolder holder, int position, Object data) {
        View[] views = holder.getParams();
        SimpleDraweeView ivIcon = (SimpleDraweeView) views[0];
        TextView tvName = (TextView) views[1];
        tvName.setText(course.courseName);
    }
}

public class ItemHolderTwo extend DataHolder{
    
    ........
}

第二步：

实例化GenericAdapter
  
public class TestActivity extends  Activity{
  
      @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = ......;
        GenericAdapter adapter = new GenericAdapter(context);
        adapter.addDataHolder(new ItemHolderOne("哈哈",0));
        adapter.addDataHolder(new ItemHolderTwo(object,1));
        rv.setAdapter(adapter);
    }
  }
