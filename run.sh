# buildAndReload task, running in background, watches for source changes
(sleep 30; gradle buildAndReload --continuous -PskipDownload=true -x Test)&
gradle bootRun -PskipDownload=true -Dspring.profiles.active=dev