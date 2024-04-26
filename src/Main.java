import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // 执行 git restore .
            Process restore = new ProcessBuilder("git", "restore", ".").start();
            restore.waitFor(); // 等待命令执行完成

            // 执行 git pull
            Process pull = new ProcessBuilder("git", "pull").start();
            pull.waitFor(); // 等待命令执行完成

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}