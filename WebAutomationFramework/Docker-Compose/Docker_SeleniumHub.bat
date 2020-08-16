set root=%CD%
echo The Path is %root%
cd /d %root%
"cmd" /c "docker-compose up"

PAUSE