CREATE TABLE "users" (
  "user_pk" BIGSERIAL PRIMARY KEY,
  "email" text,
  "password" text,
  "username" text,
  "role" text,
  "phone_number" text,
  "address" text,
  "date_of_birth" date,
  "ban_account" boolean,
  "img_avatar" text,
  "description" text,
  "created_date" date,
  "expire" date,
  "enable_users" boolean
);

CREATE TABLE "medicine" (
  "dealer_pk" bigint,
  "medicine_pk" BIGSERIAL PRIMARY KEY,
  "name_medicine" text,
  "where_production" text,
  "price" text,
  "effect" text,
  "details_medicine" text,
  "enable_medicine" boolean
);

CREATE TABLE "post_topic" (
  "post_topic_pk" BIGSERIAL PRIMARY KEY,
  "name_topic" text,
  "enable_post_topic" boolean
);

CREATE TABLE "post_thread" (
  "thread_pk" BIGSERIAL PRIMARY KEY,
  "title_thread" text,
  "time_post_thread" timestamp,
  "content_of_thread" text,
  "post_topic_pk" bigint,
  "user_pk" bigint,
  "enable_post_thread" boolean,
  "approved" boolean
);

CREATE TABLE "comment" (
  "comment_pk" BIGSERIAL PRIMARY KEY,
  "content_comment" text,
  "user_pk" bigint,
  "thread_pk" bigint,
  "enable_comment" boolean
);

CREATE TABLE "likes" (
  "like_pk" BIGSERIAL PRIMARY KEY,
  "comment_pk" bigint,
  "user_pk" bigint,
  "thread_pk" bigint,
  "enable_like" boolean
);

CREATE TABLE "image" (
  "image_pk" BIGSERIAL PRIMARY KEY,
  "thread_pk" bigint,
  "image_thread" text,
  "comment_pk" bigint,
  "image_comment" text,
  "enable_image" boolean
);

CREATE TABLE "rep_comment" (
  "comment_rep_pk" BIGSERIAL PRIMARY KEY,
  "content_comment_rep" text,
  "user_pk" bigint,
  "comment_pk" bigint,
  "enable_rep_comment" boolean
);

ALTER TABLE "post_thread" ADD FOREIGN KEY ("user_pk") REFERENCES "users" ("user_pk");

ALTER TABLE "post_thread" ADD FOREIGN KEY ("post_topic_pk") REFERENCES "post_topic" ("post_topic_pk");

ALTER TABLE "image" ADD FOREIGN KEY ("thread_pk") REFERENCES "post_thread" ("thread_pk");

ALTER TABLE "comment" ADD FOREIGN KEY ("thread_pk") REFERENCES "post_thread" ("thread_pk");

ALTER TABLE "likes" ADD FOREIGN KEY ("thread_pk") REFERENCES "post_thread" ("thread_pk");

ALTER TABLE "image" ADD FOREIGN KEY ("comment_pk") REFERENCES "comment" ("comment_pk");

ALTER TABLE "likes" ADD FOREIGN KEY ("comment_pk") REFERENCES "comment" ("comment_pk");

ALTER TABLE "comment" ADD FOREIGN KEY ("user_pk") REFERENCES "users" ("user_pk");

ALTER TABLE "likes" ADD FOREIGN KEY ("user_pk") REFERENCES "users" ("user_pk");

ALTER TABLE "rep_comment" ADD FOREIGN KEY ("user_pk") REFERENCES "users" ("user_pk");

ALTER TABLE "rep_comment" ADD FOREIGN KEY ("comment_pk") REFERENCES "comment" ("comment_pk");

ALTER TABLE "medicine" ADD FOREIGN KEY ("dealer_pk") REFERENCES "users" ("user_pk");
