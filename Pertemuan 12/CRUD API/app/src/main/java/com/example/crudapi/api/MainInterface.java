package com.example.crudapi.api;

import com.example.crudapi.delayed.DelayedResponse;
import com.example.crudapi.listuserresource.ListUserResourceResponse;
import com.example.crudapi.login.BodyLogin;
import com.example.crudapi.listuser.ListUserResponse;
import com.example.crudapi.login.LoginResponse;
import com.example.crudapi.loginunsuccessful.BodyLoginUnsuccessful;
import com.example.crudapi.loginunsuccessful.LoginUnsuccessfulResponse;
import com.example.crudapi.patch.PatchResponse;
import com.example.crudapi.post.PostResponse;
import com.example.crudapi.put.PutResponse;
import com.example.crudapi.registersuccessful.BodyRegister;
import com.example.crudapi.registersuccessful.RegisterResponse;
import com.example.crudapi.registerunsuccessful.BodyRegisterUnsuccessful;
import com.example.crudapi.registerunsuccessful.RegisterUnsuccessfulResponse;
import com.example.crudapi.singleresource.SingleUserResourceResponse;
import com.example.crudapi.singleuser.SingleUserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface MainInterface {

    // TODO Memasukkan Endpoint
    @POST("api/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

    @GET("/api/users/2")
    Call<SingleUserResponse> getSingleUser();

    @GET("/api/users/23")
    Call<SingleUserResponse> getSingleUserNotFound();

    @GET("/api/unknown")
    Call<ListUserResourceResponse> getListResource();

    @GET("/api/unknown/2")
    Call<SingleUserResourceResponse> getSingleResource();

    @GET("/api/unknown/23")
    Call<SingleUserResourceResponse> getSingleResourceNotFound();

    @FormUrlEncoded
    @POST("/api/users")
    Call<PostResponse> createPost(@Field("name") String Name, @Field("job") String Job);

    @FormUrlEncoded
    @PUT("/api/users/2")
    Call<PutResponse> updatePut(@Field("name") String Name, @Field("job") String Job);

    @FormUrlEncoded
    @PATCH("/api/users/2")
    Call<PatchResponse> updatePatch(@Field("name") String Name, @Field("job") String Job);

    @DELETE("/api/users/2")
    Call<SingleUserResponse> deleteUser();

    @POST("api/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    @POST("api/register")
    Call<RegisterUnsuccessfulResponse> postRegisterUnsuccessful(@Body BodyRegisterUnsuccessful bodyRegisterUnsuccessful);

    @POST("api/login")
    Call<LoginUnsuccessfulResponse> postUnsuccessLogin(@Body BodyLoginUnsuccessful bodyLoginUnsuccessful);

    @GET("/api/users?delay=3")
    Call<DelayedResponse> getDelayed();

}
