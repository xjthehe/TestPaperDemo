package bean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/7.
 */
public class TestPaperBean {


    /**
     * list : [{"id":1,"condition":0,"topic":"您是否存在有害物质职业接触?","option":{"desA":"否","desB":"是","desC":"","desD":""}},{"id":2,"condition":0,"topic":"您是否吸烟,如果吸烟,吸烟指数(每天吸烟支数×吸烟年数)是否≥100?","option":{"desA":"否,从不吸","desB":"是,吸烟指数吸烟指数指数<100","desC":"是,吸烟指数≥100","desD":""}},{"id":3,"condition":50,"topic":"您近十年来的生活环境是否存在较严重空气污染(如长期在大城市生活则直接被认定有空气污染)?","option":{"desA":"否","desB":"是","desC":"","desD":""}},{"id":4,"condition":0,"topic":"您目前或曾经是否患有以下疾病(经正规医疗机构明确诊断)?","option":{"desA":"否","desB":"慢性呼吸系统疾病","desC":"","desD":""}},{"id":5,"condition":0,"topic":"您的血缘亲属中,是否有人曾患以下疾病?","option":{"desA":"否","desB":"肺癌","desC":"","desD":""}}]
     */

    private List<ListEntity> list;

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity {
        /**
         * id : 1
         * condition : 0
         * topic : 您是否存在有害物质职业接触?
         * option : {"desA":"否","desB":"是","desC":"","desD":""}
         */

        private int id;
        private int condition;
        private String topic;
        private OptionEntity option;

        public void setId(int id) {
            this.id = id;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public void setOption(OptionEntity option) {
            this.option = option;
        }

        public int getId() {
            return id;
        }

        public int getCondition() {
            return condition;
        }

        public String getTopic() {
            return topic;
        }

        public OptionEntity getOption() {
            return option;
        }

        public static class OptionEntity {
            /**
             * desA : 否
             * desB : 是
             * desC :
             * desD :
             */

            private String desA;
            private String desB;
            private String desC;
            private String desD;

            public void setDesA(String desA) {
                this.desA = desA;
            }

            public void setDesB(String desB) {
                this.desB = desB;
            }

            public void setDesC(String desC) {
                this.desC = desC;
            }

            public void setDesD(String desD) {
                this.desD = desD;
            }

            public String getDesA() {
                return desA;
            }

            public String getDesB() {
                return desB;
            }

            public String getDesC() {
                return desC;
            }

            public String getDesD() {
                return desD;
            }
        }
    }
}
