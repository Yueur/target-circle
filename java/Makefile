
SOURCE_LIST_FILE= .source.txt
SOURCE_FOLDER= src/
DESTIONATION_FOLDER= bin/

JAR_OUTPUT_FILE= target.jar

JUNIT_JAR=/usr/share/java/junit4.jar

all: javas $(JAR_OUTPUT_FILE)
	

# JAVAs for JAR
javas: $(DESTIONATION_FOLDER)
	@echo "Compiling Java source files for JAR..."
	@find -name "*.java" ! -path "*/test/*" > $(SOURCE_LIST_FILE)
	@javac -d $(DESTIONATION_FOLDER) @$(SOURCE_LIST_FILE)
	@rm $(SOURCE_LIST_FILE)
	@echo "Compiling done"
	@echo ""


.PHONY: $(DESTIONATION_FOLDER)
$(DESTIONATION_FOLDER): 
	@if [ ! -d $(DESTIONATION_FOLDER) ]; then\
		echo "Output directory not ready"; \
		mkdir -p $(DESTIONATION_FOLDER); \
		echo "Output directory created"; \
	fi

.PHONY: $(JAR_OUTPUT_FILE)
$(JAR_OUTPUT_FILE):
	@echo "Creating the JAR file"
	@jar cfm $(JAR_OUTPUT_FILE) manifest.mf -C bin/ .
	@echo "JAR File succesfully created !"
	@echo ""
	@echo "To run just exec:    java -jar $(JAR_OUTPUT_FILE)"
	@echo ""

# ---------
.PHONY: compile_test
compile_test: $(DESTIONATION_FOLDER)
	@echo "Compiling all Java source files..."
	@find -name "*.java" > $(SOURCE_LIST_FILE)
	@javac -classpath $(JUNIT_JAR) -d $(DESTIONATION_FOLDER) @$(SOURCE_LIST_FILE)
	@rm $(SOURCE_LIST_FILE)
	@echo "Compiling done"
	@echo ""

.PHONY: compile_test
test: compile_test
	java -classpath $(JUNIT_JAR) -classpath bin/ targetcircle.Main

