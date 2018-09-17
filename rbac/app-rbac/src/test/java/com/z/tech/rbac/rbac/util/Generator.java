package com.z.tech.rbac.rbac.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Generator {

    private static final String NAMES = "回家变卖典质父亲还了亏空又借钱办了丧事这些日子家中光景很是惨淡一半为了丧事一半为了父亲赋闲丧事完毕父亲要到南京谋事我也要回北京念书我们便同行" +
            "到南京时有朋友约去游逛勾留了一日第二日上午便须渡江到浦口下午上车北去父亲因为事忙本已说定不送我叫旅馆里一个熟识的茶房陪我同去他再三嘱" +
            "咐茶房甚是仔细但他终于不放心怕茶房不妥帖颇踌躇了一会其实我那年已二十岁北京已来往过两三次是没有甚么要紧的了他踌躇了一会终于决定还是自" +
            "己送我去我两三回劝他不必去他只说不要紧他们去不好" +
            "我们过了江进了车站我买票他忙着照看行李行李太多了得向脚夫行些小费才可过去他便又忙着和他们讲价钱我那时真是聪明过分总觉他说话不大漂亮非" +
            "自己插嘴不可但他终于讲定了价钱就送我上车他给我拣定了靠车门的一张椅子我将他给我做的紫毛大衣铺好坐位他嘱我路上小心夜里警醒些不要受凉" +
            "又嘱托茶房好好照应我我心里暗笑他的迂他们只认得钱托他们直是白托而且我这样大年纪的人难道还不能料理自己么唉我现在想想那时真是太聪明了" +
            "我说道爸爸你走吧他望车外看了看说我买几个橘子去你就在此地不要走动我看那边月台的栅栏外有几个卖东西的等着顾客走到那边月台" +
            "须穿过铁道须跳下去又爬上去父亲是一个胖子走过去自然要费事些我本来要去的他不肯只好让他去我看见他戴着黑布小帽穿着黑布大马褂" +
            "深青布棉袍蹒跚地走到铁道边慢慢探身下去尚不大难可是他穿过铁道要爬上那边月台就不容易了他用两手攀着上面两脚再向上缩他肥胖的身" +
            "子向左微倾显出努力的样子这时我看见他的背影我的泪很快地流下来了我赶紧拭干了泪怕他看见也怕别人看见我再向外看时他已抱了朱红的橘" +
            "子望回走了过铁道时他先将橘子散放在地上自己慢慢爬下再抱起橘子走到这边时我赶紧去搀他他和我走到车上将橘子一股脑儿放在我的皮大衣上" +
            "于是扑扑衣上的泥土心里很轻松似的过一会说我走了到那边来信我望着他走出去他走了几步回过头看见我说进去吧里边没人等他的背影混入来来往往的人里" +
            "再找不着了我便进来坐下我的眼泪又来了" +
            "近几年来父亲和我都是东奔西走家中光景是一日不如一日他少年出外谋生独力支持做了许多大事那知老境却如此颓唐他触目伤怀自然情不能自已情郁于中自然要发" +
            "之于外家庭琐屑便往往触他之怒他待我渐渐不同往日但最近两年的不见他终于忘却我的不好只是惦记着我惦记着我的儿子我北来后他写了一信给我信中说道我身体平安惟膀子" +
            "疼痛利害举箸提笔诸多不便大约大去之期不远矣我读到此处在晶莹的泪光中又看见那肥胖的青布棉袍黑布马褂的背影唉我不知何时再能与他相见";
    /**
     * 返回手机号码
     */
    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static List<String> generateNameOfQuantity(String prefixCharacter, int quantity) {

        List<String> names = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            names.add(getName(prefixCharacter, 4));
        }
        return names;
    }

    public static String getName(String prexCharacter, int nameLength) {

        int length = NAMES.length();
        StringBuilder genName = new StringBuilder(nameLength);
        for (int i = 0; i < nameLength; i++) {
            Random random = new Random();
            int indx = random.nextInt(length);
            genName.append(NAMES.charAt(indx));
        }
        return prexCharacter + genName.toString();
    }

    private static int getNum(int start, int end) {

        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static String getTel() {

        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    public static List<String> generateTelOfQuantity(String prefixCharacter, int quantity) {

        List<String> tels = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            String tel = prefixCharacter + getTel();
            tels.add(tel);
        }
        while (true) {
            Long count = tels.stream().distinct().count();
            int effectSize = count.intValue();
            if (effectSize != quantity) {
                int needNumber = quantity - effectSize;
                System.out.println("实际需要[" + quantity + "]个电话号码,有效的是[" + effectSize + "]个，还需要[" + needNumber + "]个");
                tels.addAll(generateTelOfQuantity(prefixCharacter, needNumber));
                continue;
            }
            break;
        }
        return tels.parallelStream().distinct().collect(Collectors.toList());
    }

    public static List<String> generateIDnumberOfQuantity(String prefixCharacter, int quantity) {
        IdCardGenerator g = new IdCardGenerator();
        List<String> IDs = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            String generate = g.generate();
            String target = prefixCharacter + generate;
            if (target.length() > 18) {
                target = target.substring(0, 18);
            }
            IDs.add(target);
        }
        while (true) {
            Long count = IDs.stream().distinct().count();
            int effectSize = count.intValue();
            if (effectSize != quantity) {
                int needNumber = quantity - effectSize;
                System.out.println("实际需要[" + quantity + "]个身份证号码,有效的是[" + effectSize + "]个，还需要[" + needNumber + "]个");
                IDs.addAll(generateIDnumberOfQuantity(prefixCharacter, needNumber));
                continue;
            }
            break;
        }
        return IDs.parallelStream().distinct().collect(Collectors.toList());
    }


    public static void main(String[] args) {

        int size = 100000;
        List<String> tels = generateIDnumberOfQuantity("A", size);
        Long count = tels.stream().distinct().count();
        System.out.println("返回数量:" + tels.size() + "---- ---- 有效数量:" + count.intValue());

    }


}
