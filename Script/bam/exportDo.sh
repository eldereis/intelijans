. ./envbam.sh

export PATH=$BAM_HOME/bin:$PATH
icommand -cmd export -name /TemplateSRR/TemplateSRR_DO -type dataobject -contents 0 -file $PATH_TO_EXPORT_DO/TemplateSRR_DO.xml
