package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.UserCreate;
import model.UserLogin;

import static data.TestData.*;
import static io.restassured.RestAssured.given;

// Шаги для пользователя
public class UserSteps {

    // Шаг, который создаёт нового пользователя
    @Step("Создаём нового пользователя через API")
    public static Response createNewUser(UserCreate userCreate) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userCreate)
                .when()
                .post(CREATE_USER_PATH)
                .then()
                .extract().response();
    }

    // Шаг, который авторизует пользователя в системе и сохраняет accessToken для дальнейшей работы
    @Step ("Авторизуемся в системе через API")
    public static String loginUser(UserLogin userLogin) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(userLogin)
                .when()
                .post(LOGIN_USER_PATH)
                .then()
                .extract().path("accessToken");
    }

    // Шаг, который удаляет пользователя
    @Step ("Удаляем пользователя через API")
    public static void deleteUser(String accessToken) {
        given()
                .log().all()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER_PATH);
    }

    // Шаг, который авторизует пользователя, сохраняет accessToken и удаляет пользователя
    @Step ("Авторизуемся, сохраняем accessToken и удаляем пользователя через API")
    public void cleanUp(UserLogin userLogin, String email) {
        String accessToken = loginUser(userLogin);
        if (accessToken != null) {
            deleteUser(accessToken);
            System.out.println("Пользователь " + email + " успешно удалён");
        } else {
            System.out.println("Пользователя с таким email не найдено");
        }
    }
}