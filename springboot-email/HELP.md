# Getting Started
####   邮件服务(单实例的邮件服务)

####  SpringBoot 发送邮件和附件 理论

#####  springboot 集成邮件服务，快速入手邮件业务核心逻辑和企业邮件的日常服务
    基础知识
    
    * 什么是SMTP?
    
    SMTP全称为 Simple Mail Transfer Protoccol(简单邮件传输协议)，它是一组用于从源地址到目的地址传输邮件的规范，通过它来控制邮件的中转方式。
    SMTP认证要求必须提供账号和密码才能登录服务器，其设计目的在于避免用户收到垃圾邮件的侵扰。
    
    * 什么是IMAP 
    
    IMAP全称Internet Message Access protocol（互联网传输协议），IMAP允许从邮件服务器上获取邮件的信息、下载邮件等。IMAP与POP类似，都是一种获取邮件协议。
    
    * 什么是POP3
    
    POP3 全称为Post Office Protocol3(邮局协议)，POP3支持客户端远程管理服务器端的邮件。POP3常用与离线的邮件处理，即允许客户端下载服务器邮件，然后服务器
    上的邮件将会被删除。目前很多POP3的邮件服务器只能提供下载邮件功能，服务器本身并不能删除邮件，这种属于改进版的POP3协议。
    
    * IMAP 与POP3 协议有什么不同
    
    两者最大的区别在于，IMAP允许双向通信，即在客户端的操作会反馈到服务器上，例如在客户端收取邮件，标记已读等操作，服务器会跟着同步这些操作。而POP协议虽然也允许
    客户端下载服务器邮件，但是在客户端的操作并不会同步到服务器上面，例如在客户端收取活标记已读邮件，服务器不会同步这些操作。
    
    进阶知识
    
    * 什么是JavaMailSender 和JavaMailSenderImpl
    
    JavaMailSender 和JavaMailSenderImpl是Spring官方提供的集成邮件服务的接口，和实现类，以简单高效的设计著称，目前是java后端发送邮件和集成邮件服务的主流工具。
    
    * 如何通过javaMailSenderImpl发送邮件
    
    直接在业务类注入JavaMailSenderImpl并调用send方法发送邮件。其中简单邮件可以通过SimpleMailMessage来发送邮件，而复杂的邮件（例如添加附件）可以借助MimeMessageHelper
    来构建MimeMessage发送邮件例如：
    
        @Autowired
        private JavaMailSenderImpl mailSender;
    
        public void sendMail() throws MessagingException {
            //简单邮件
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("admin@163.com");
            simpleMailMessage.setTo("socks@qq.com");
            simpleMailMessage.setSubject("Happy New Year");
            simpleMailMessage.setText("新年快乐！");
            mailSender.send(simpleMailMessage);
    
            //复杂邮件
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("admin@163.com");
            messageHelper.setTo("socks@qq.com");
            messageHelper.setSubject("Happy New Year");
            messageHelper.setText("新年快乐！");
            messageHelper.addInline("doge.gif", new File("xx/xx/doge.gif"));
            messageHelper.addAttachment("work.docx", new File("xx/xx/work.docx"));
            mailSender.send(mimeMessage);
        }
        
        
        * 为什么JavaMailSenderImpl 能够开箱即用 ？
          所谓开箱即用其实就是基于官方内置的自动配置，翻看源码可知晓邮件自动配置类(MailSenderPropertiesConfiguration) 为上下文提供了邮件服务实例(JavaMailSenderImpl)。具体源码如下：
          
          @Configuration
          @ConditionalOnProperty(prefix = "spring.mail", name = "host")
          class MailSenderPropertiesConfiguration {
              private final MailProperties properties;
              MailSenderPropertiesConfiguration(MailProperties properties) {
                  this.properties = properties;
              }
              @Bean
              @ConditionalOnMissingBean
              public JavaMailSenderImpl mailSender() {
                  JavaMailSenderImpl sender = new JavaMailSenderImpl();
                  applyProperties(sender);
                  return sender;
              }
          其中MailProperties是关于邮件服务器的配置信息，具体源码如下
          @ConfigurationProperties(prefix = "spring.mail")
          public class MailProperties {
              private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
              private String host;
              private Integer port;
              private String username;
              private String password;
              private String protocol = "smtp";
              private Charset defaultEncoding = DEFAULT_CHARSET;
              private Map<String, String> properties = new HashMap<>();
          }
          
          
          注：根据前面提到的配置项（mailProperties）填写相关配置信息，其中spring.mail.username表示链接邮件服务器时认证的登录账号，可以是普通的手机号
          或者登录账号，并非一定是邮箱，为了解决这个问题，推荐大家使用spring.mail.properties.from填写邮件发信人即真实邮箱。
          
          透过前面的知识，发邮件之前需要构建SimpleMailMessage或者MimeMessage邮件信息类来填写邮件标题、邮件内容等信息。最后提交给JavaMailSenderImpl发送邮件。
          这样看起来没什么问题，也能实现既定目标，但实际使用中出现大量零散和重复代码，这不便于保存邮件到数据库。
          
          例如通过封装成一个邮件信息类（代码中的  MailVo）来保存发送邮件的主题、邮件内容。
          public class MailVo {
              private String id;//邮件id
              private String from;//邮件发送人
              private String to;//邮件接收人（多个邮箱则用逗号","隔开）
              private String subject;//邮件主题
              private String text;//邮件内容
              private Date sentDate;//发送时间
              private String cc;//抄送（多个邮箱则用逗号","隔开）
              private String bcc;//密送（多个邮箱则用逗号","隔开）
              private String status;//状态
              private String error;//报错信息
              @JsonIgnore
              private MultipartFile[] multipartFiles;//邮件附件
             
          }
          
              





基础的邮箱发送

邮箱发送的功能放在现在变得非常的简单好用，一导二配三发送。

第一步：导入邮箱依赖包

        <!-- 邮件服务 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>

第二步：配置发件人邮箱信息
    
    spring:
      mail:
       host: smtp.mxhichina.com
       username: itdragon@xx
       password: itdragon
       default-encoding: utf-8
   
第三步：发送邮件

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单文本邮件
     * @param to 邮件的接收人
     * @param subject  主题
     * @param content 内容
     */
    @PostMapping(value = "/sendSimpleTextMail")
    public void sendSimpleTextMail(String to,String subject,String content){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);//发送的目标人
        simpleMailMessage.setSubject(subject);//主题
        simpleMailMessage.setFrom(from);//发送者
        simpleMailMessage.setText(content);//邮件的内容
        mailSender.send(simpleMailMessage);
        log.info("【文本邮件】成功发送！to={}",to);

    }


####   邮件服务(多实例的邮件服务，即可动态配置邮件发送方)