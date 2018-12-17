package GUIStudy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 初次尝试使用JavaFX来编写JavaGUI界面
 * <p>
 * JavaFX应用程序的主类需要继承自application.Application类。start()方法是所有JavaFX应用程序的入口。
 * 在主函数中调用Application.launch(args)
 * <p>
 * Stage:窗口,可以设置title等属性
 * parent：双亲(抽象类)，其子类负责Scene中组件的摆放
 * BorderPane:按照上(top)、下(bottom)、左(left)、右(right)、中(center)的位置放置组件
 * HBox:将组件按行排列
 * VBox:组件按列排列
 * StackPane：按照栈的顺序，将组件堆叠在一起
 * GridPane：根据行列组成的网格来摆放组件
 * FlowPane：按行排列，并且自动换行
 * Scene：窗口内的布局空间，相当于存放组件的容器
 * 在Scene中添加各种组件即可
 * <p>
 * 需要在start函数的 结尾调用Stage.show()来显示页面
 * <p>
 * author:Benjamin
 * date:2018.12.17
 */


public class FirstJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        Scene scene = new Scene(pane, 400, 300);
        Button btn = new Button("ok");
        // 设置按钮的点击事件处理
        btn.setOnAction(event -> {
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            pane.add(btn, col, row);
        });
        pane.add(btn, 5, 5);

        primaryStage.setTitle("first javafx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}