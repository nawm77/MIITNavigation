CREATE TABLE "Subject" (
                           "id" serial NOT NULL,
                           "name" varchar(255) NOT NULL,
                           CONSTRAINT "Subject_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Teacher" (
                           "id" serial NOT NULL,
                           "nameSurname" varchar(255) NOT NULL,
                           CONSTRAINT "Teacher_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Time" (
                        "id" serial NOT NULL,
                        "timeStart" integer NOT NULL,
                        "timeEnd" integer NOT NULL,
                        CONSTRAINT "Time_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Day" (
                       "id" serial NOT NULL,
                       "dayName" varchar(255) NOT NULL,
                       CONSTRAINT "Day_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Auditorium" (
                              "id" serial NOT NULL,
                              "auditriumNumber" integer NOT NULL,
                              CONSTRAINT "Auditorium_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Group" (
                         "id" serial NOT NULL,
                         "groupName" varchar(255) NOT NULL,
                         CONSTRAINT "Group_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Time_table" (
                              "id" serial NOT NULL,
                              "subjectId" integer NOT NULL,
                              "teacherId" integer NOT NULL,
                              "timeId" integer NOT NULL,
                              "dayId" integer NOT NULL,
                              "auditoriumId" integer NOT NULL,
                              "isEven" BOOLEAN NOT NULL,
                              CONSTRAINT "Time_table_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );



CREATE TABLE "Groups_timetable" (
                                    "id" serial NOT NULL,
                                    "groupId" integer NOT NULL,
                                    "timeTableId" integer NOT NULL,
                                    CONSTRAINT "Groups_timetable_pk" PRIMARY KEY ("id")
) WITH (
      OIDS=FALSE
    );









ALTER TABLE "Time_table" ADD CONSTRAINT "Time_table_fk0" FOREIGN KEY ("subjectId") REFERENCES "Subject"("id");
ALTER TABLE "Time_table" ADD CONSTRAINT "Time_table_fk1" FOREIGN KEY ("teacherId") REFERENCES "Teacher"("id");
ALTER TABLE "Time_table" ADD CONSTRAINT "Time_table_fk2" FOREIGN KEY ("timeId") REFERENCES "Time"("id");
ALTER TABLE "Time_table" ADD CONSTRAINT "Time_table_fk3" FOREIGN KEY ("dayId") REFERENCES "Day"("id");
ALTER TABLE "Time_table" ADD CONSTRAINT "Time_table_fk4" FOREIGN KEY ("auditoriumId") REFERENCES "Auditorium"("id");

ALTER TABLE "Groups_timetable" ADD CONSTRAINT "Groups_timetable_fk0" FOREIGN KEY ("groupId") REFERENCES "Group"("id");
ALTER TABLE "Groups_timetable" ADD CONSTRAINT "Groups_timetable_fk1" FOREIGN KEY ("timeTableId") REFERENCES "Time_table"("id");


insert into "Auditorium" (id, "auditriumNumber") values (1, 1523)