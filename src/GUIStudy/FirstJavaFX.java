/**
 * 初次尝试使用JavaFX来编写JavaGUI界面
 *
 * JavaFX应用程序的主类需要继承自application.Application类。start()方法是所有JavaFX应用程序的入口。
 * 在主函数中调用Application.launch(args)
 *
 * Stage:窗口
 * Scene：窗口内的布局空间，相当于tkinter中的frame
 * 在Scene中添加各种组件即可
 *
 * 需要在start函数的 结尾调用Stage.show()来显示页面
 *
 * @author:Benjamin
 */
package GUIStudy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FirstJavaFX extends Application {

    @Override
    public void start(Stage primaryStage){

//        StackPane root = new StackPane();
//        Scene Graph = new Scene(root,800,600);
//        Button btn = new Button();
//        btn.setText("按钮");
//        root.getChildren().add(btn);
//
//        primaryStage.setTitle("my first javafx!");
//        primaryStage.setScene(Graph);
//        primaryStage.show();

        BorderPane root = new BorderPane();
        Button btn = new Button("ok");
        root.setCenter(btn);
        Scene scene = new Scene(root, 400,500);

        primaryStage.setTitle("first javafx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}