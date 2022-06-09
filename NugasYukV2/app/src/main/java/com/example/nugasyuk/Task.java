package com.example.nugasyuk;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_tugas")
public class Task implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "judultugas")
    @NonNull
    public String judulTugas;

    @ColumnInfo(name = "tanggal")
    @NonNull
    public String tanggal;

    @ColumnInfo(name = "jam")
    @NonNull
    public String jam;

    @ColumnInfo(name = "note")
    @NonNull
    public String note;

    public Task(String judulTugas, String tanggal, String jam, String note) {
        this.judulTugas = judulTugas;
        this.tanggal = tanggal;
        this.jam = jam;
        this.note = note;
    }

    public String getJudulTugas() { return judulTugas; }
    public void setJudulTugas(String judulTugas) { this.judulTugas = judulTugas; }
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String getJam() {
        return jam;
    }
    public void setJam(String jam) {
        this.jam = jam;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(judulTugas);
        parcel.writeString(tanggal);
        parcel.writeString(jam);
        parcel.writeString(note);
    }

    protected Task (Parcel in){
        id = in.readInt();
        judulTugas = in.readString();
        tanggal = in.readString();
        jam = in.readString();
        note = in.readString();
    }

    public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel source) {
            return new Task(source);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}
